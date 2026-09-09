package com.vu.s8119575assignment2.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.vu.s8119575assignment2.R
import com.vu.s8119575assignment2.ui.dashboard.DashboardScreenFragmentArgs
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.Lifecycle
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class DashboardScreenFragment : Fragment() {

    private val viewModel: DashboardViewModel by viewModels()
    private val args: DashboardScreenFragmentArgs by navArgs()

    private val entityAdapter = EntityAdapter { entity ->
        val action = DashboardScreenFragmentDirections
            .actionDashboardScreenFragmentToDetailsScreenFragment(entity)

        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_dashboard_screen,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entityRecyclerView = view.findViewById<RecyclerView>(R.id.entityRecyclerView)

        entityRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        entityRecyclerView.adapter = entityAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getDashboardData(args.keypass)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                launch {
                    viewModel.entities.collect { entities ->
                        entityAdapter.updateData(entities)
                    }
                }

                launch {
                    viewModel.errorMessage.collect { message ->
                        if (message != null) {
                            Toast.makeText(
                                requireContext(),
                                message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }
}
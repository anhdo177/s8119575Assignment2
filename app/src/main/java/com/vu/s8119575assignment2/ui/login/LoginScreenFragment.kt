package com.vu.s8119575assignment2.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vu.s8119575assignment2.R
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.vu.s8119575assignment2.ui.LoginViewModel
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class LoginScreenFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_login_screen,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val studentIdField = view.findViewById<TextInputEditText>(R.id.studentIdField)

        val passwordField = view.findViewById<TextInputEditText>(R.id.passwordField)

        val loginButton = view.findViewById<View>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = studentIdField.text.toString().trim()
            val password = passwordField.text.toString()

            viewLifecycleOwner.lifecycleScope.launch {
                viewModel.login(username, password)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
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

                launch {
                    viewModel.keypass.collect { keypass ->
                        if (keypass != null) {
                            val action = LoginScreenFragmentDirections
                                .actionLoginScreenFragmentToDashboardScreenFragment(
                                    keypass
                                )

                            findNavController().navigate(action)
                            viewModel.clearKeypass()
                        }
                    }
                }
            }
        }

    }
}
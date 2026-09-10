package com.vu.s8119575assignment2.ui

import androidx.navigation.fragment.navArgs
import androidx.fragment.app.Fragment
import android.view.View
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import androidx.navigation.fragment.findNavController
import com.vu.s8119575assignment2.R
class DetailsScreenFragment : Fragment(R.layout.fragment_details_screen) {

    private val args: DetailsScreenFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entity = args.entity

        val backButton = view.findViewById<MaterialButton>(R.id.detailBackButton)
        val deviceNameText = view.findViewById<TextView>(R.id.detailDeviceNameText)
        val manufacturerText = view.findViewById<TextView>(R.id.detailManufacturerText)
        val operatingSystemText = view.findViewById<TextView>(R.id.detailOperatingSystemText)
        val releaseYearText = view.findViewById<TextView>(R.id.detailReleaseYearText)
        val descriptionText = view.findViewById<TextView>(R.id.detailDescriptionText)

        deviceNameText.text = entity.deviceName
        manufacturerText.text = entity.manufacturer
        operatingSystemText.text = entity.operatingSystem
        releaseYearText.text = entity.releaseYear.toString()
        descriptionText.text = entity.description

        backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
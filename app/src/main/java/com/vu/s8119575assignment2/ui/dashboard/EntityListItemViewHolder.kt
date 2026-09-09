package com.vu.s8119575assignment2.ui.dashboard

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.vu.s8119575assignment2.R
import com.vu.s8119575assignment2.network.data.dashboard.Entity
import com.google.android.material.button.MaterialButton

class EntityListItemViewHolder(view: View):  RecyclerView.ViewHolder(view) {

    private val deviceNameText: TextView = view.findViewById<TextView>(R.id.deviceNameText)
    private val manufacturerText: TextView = view.findViewById<TextView>(R.id.manufacturerText)
    private val operatingSystemText: TextView = view.findViewById<TextView>(R.id.operatingSystemText)
    private val releaseYearText: TextView = view.findViewById<TextView>(R.id.releaseYearText)

    private val viewDetailsButton: MaterialButton = view.findViewById<MaterialButton>(R.id.viewDetailsButton)

    fun bind(item: Entity, onClickFunction: (Entity) -> Unit) {
        deviceNameText.text = item.deviceName
        manufacturerText.text = item.manufacturer
        operatingSystemText.text = item.operatingSystem
        releaseYearText.text = item.releaseYear.toString()
        viewDetailsButton.setOnClickListener {
            onClickFunction(item)
        }
    }
}
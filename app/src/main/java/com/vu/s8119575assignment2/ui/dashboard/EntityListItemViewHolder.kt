package com.vu.s8119575assignment2.ui.dashboard

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.vu.s8119575assignment2.R
import com.vu.s8119575assignment2.network.data.dashboard.Entity

class EntityListItemViewHolder(view: View):  RecyclerView.ViewHolder(view) {

    private val deviceNameText: TextView = view.findViewById<TextView>(R.id.deviceNameText)
    private val manufacturerText: TextView = view.findViewById<TextView>(R.id.manufacturerText)
    private val operatingSystemText: TextView = view.findViewById<TextView>(R.id.operatingSystemText)
    private val releaseYearText: TextView = view.findViewById<TextView>(R.id.releaseYearText)

    fun bind(item: Entity) {
        deviceNameText.text = item.deviceName
        manufacturerText.text = item.manufacturer
        operatingSystemText.text = item.operatingSystem
        releaseYearText.text = item.releaseYear.toString()
    }
}
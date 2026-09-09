package com.vu.s8119575assignment2.ui.dashboard

import com.vu.s8119575assignment2.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vu.s8119575assignment2.network.data.dashboard.Entity

class EntityAdapter (private val dataList: MutableList<Entity> = mutableListOf<Entity>(), val onClickFunction: (Entity) -> Unit): RecyclerView.Adapter<EntityListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.entity_item_layout, parent,
            false
        )
        return EntityListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityListItemViewHolder, position: Int) {
        holder.bind(dataList[position], onClickFunction)
    }

    override fun getItemCount() = dataList.size

    fun updateData(entityListData: List<Entity>) {
        dataList.clear()
        dataList.addAll(entityListData)
        notifyDataSetChanged()
    }
}

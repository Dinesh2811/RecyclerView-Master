package com.dinesh.recyclerview.kotlin.swipegesture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.recyclerview.R

class ItemAdapter(private val context: SG_MainActivity, private val list: List<String>) :
    RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.sg_list_adapter_item, parent, false))

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = list[position]

        holder.dragButton.setOnTouchListener { _, _ ->
            context.startDragging(holder)
            return@setOnTouchListener true
        }
    }

    override fun getItemCount() = list.size
}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.tv_text)
    val dragButton: ImageButton = view.findViewById(R.id.iv_drag)
}
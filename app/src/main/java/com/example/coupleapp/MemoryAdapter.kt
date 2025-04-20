package com.example.coupleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class MemoryAdapter(private val memories: List<Memory>) : 
    RecyclerView.Adapter<MemoryAdapter.MemoryViewHolder>() {

    class MemoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.memoryImage)
        val titleView: TextView = view.findViewById(R.id.memoryTitle)
        val descriptionView: TextView = view.findViewById(R.id.memoryDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_memory, parent, false)
        return MemoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemoryViewHolder, position: Int) {
        val memory = memories[position]
        
        // Cargar imagen usando Glide con animación de fade
        Glide.with(holder.imageView)
            .load(memory.imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .centerCrop()
            .into(holder.imageView)

        // Establecer textos
        holder.titleView.text = memory.title
        holder.descriptionView.text = memory.description
    }

    override fun getItemCount() = memories.size
}

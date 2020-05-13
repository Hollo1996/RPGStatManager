package com.example.rpgstatmanager.view.recycle

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.model.D_Adventure

class AdventureAdapter(
    val context: Context,
    val adventure: List<D_Adventure>
) : RecyclerView.Adapter<AdventureAdapter.AdventureViewHolder>() {

    var itemClickListener: AdventureClickListener? = null

    inner class AdventureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvname: TextView = itemView.findViewById(R.id.tvAdventureNameRow)
        val image: ImageView = itemView.findViewById(R.id.ivAdventureimageRow)
        val tvtype: TextView = itemView.findViewById(R.id.tvAsDmRow)

        var adventure: D_Adventure? = null

        init {
            itemView.setOnClickListener {
                adventure?.let { ad ->
                    itemClickListener?.onItemClick(ad)

                }
            }
        }
    }

    interface AdventureClickListener {
        fun onItemClick(adventure: D_Adventure)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdventureViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_item_adventure, parent, false)
        return AdventureViewHolder(view)
    }

    override fun getItemCount() = adventure.size

    override fun onBindViewHolder(holder: AdventureViewHolder, position: Int) {
        holder.tvname.setText(adventure[position].name)
        if (!adventure[position].is_gm)
            holder.tvtype.setText("")

        //image
    }
}
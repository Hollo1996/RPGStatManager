package com.example.rpgstatmanager.view.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.D_Character

class AdventureCreatePlayersAdapter(
    val context: Context
) : RecyclerView.Adapter<AdventureCreatePlayersAdapter.AdventurePlayerViewHolder>() {
     val adventure = mutableListOf<D_Character>()

    class AdventurePlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvname: TextView = itemView.findViewById(R.id.tvAdventureNameRow)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdventureCreatePlayersAdapter.AdventurePlayerViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_item_character_name, parent, false)
        return AdventurePlayerViewHolder(view)
    }

    override fun getItemCount(): Int = adventure.size

    override fun onBindViewHolder(
        holder: AdventureCreatePlayersAdapter.AdventurePlayerViewHolder,
        position: Int
    ) {
        holder.tvname.setText(adventure[position].name)
    }
}
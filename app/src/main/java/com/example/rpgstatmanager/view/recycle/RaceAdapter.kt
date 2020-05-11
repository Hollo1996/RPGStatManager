package com.example.rpgstatmanager.view.recycle


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.character.D_Ability


class RaceAdapter(
    val context: Context,
    val abilities: List<D_Ability>
) : RecyclerView.Adapter<RaceAdapter.RaceViewHolder>() {

    class RaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvname: TextView = itemView.findViewById(R.id.tvAbilityName)
        val tvtype: TextView = itemView.findViewById(R.id.tvAbilityType)
        val tvdescription: TextView = itemView.findViewById(R.id.tvAbilityDescription)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RaceAdapter.RaceViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_item_ability, parent, false)
        return RaceViewHolder(view)
    }

    override fun getItemCount(): Int = abilities.size


    override fun onBindViewHolder(
        holder: RaceAdapter.RaceViewHolder,
        position: Int
    ) {
        holder.tvdescription.setText(abilities[position].description)
        holder.tvname.setText(abilities[position].name)
        holder.tvtype.setText(abilities[position].effect)
    }

}
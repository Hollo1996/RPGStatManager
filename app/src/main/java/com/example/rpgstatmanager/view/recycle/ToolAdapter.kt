package com.example.rpgstatmanager.view.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.character.D_Tool

class ToolAdapter(
    val context: Context,
    val weapons: List<D_Tool>
) : RecyclerView.Adapter<ToolAdapter.ToolViewHolder>() {

    class ToolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listMove: List<MoveAdapter.MoveViewHolder> = listOf(
            MoveAdapter.MoveViewHolder(itemView.findViewById(R.id.move1OfWeapon)),
            MoveAdapter.MoveViewHolder(itemView.findViewById(R.id.move2OfWeapon)),
            MoveAdapter.MoveViewHolder(itemView.findViewById(R.id.move3OfWeapon)),
            MoveAdapter.MoveViewHolder(itemView.findViewById(R.id.move4OfWeapon))
        )
        val name: EditText = itemView.findViewById(R.id.nameOfMove)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_item_weapon, parent, false)
        return ToolViewHolder(view)
    }

    override fun getItemCount() = weapons.size

    override fun onBindViewHolder(holder: ToolViewHolder, position: Int) {
        holder.name.setText(weapons[position].name)
        for (i in holder.listMove.indices) {
            holder.listMove[i].name.setText(weapons[position].DMoves[i].name)
            holder.listMove[i].criteria.setText(weapons[position].DMoves[i].cardRestriction)
            holder.listMove[i].description.setText(weapons[position].DMoves[i].description)
            holder.listMove[i].effect.setText(weapons[position].DMoves[i].effect)
        }
    }
}
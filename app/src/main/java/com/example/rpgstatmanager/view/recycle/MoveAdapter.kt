package com.example.rpgstatmanager.view.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.character.D_Move

class MoveAdapter(
    val context: Context,
    val weapons: List<D_Move>
) : RecyclerView.Adapter<MoveAdapter.MoveViewHolder>() {

    class MoveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : EditText= itemView.findViewById(R.id.nameOfMove)
        val type : Spinner = itemView.findViewById(R.id.typeOfMove)
        val criteria  : EditText= itemView.findViewById(R.id.criteriaOfMove)
        val description  : EditText= itemView.findViewById(R.id.descriptionOfMove)
        val effect  : EditText= itemView.findViewById(R.id.criteriaOfMove)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_item_weapon, parent, false)
        return MoveViewHolder(view)
    }

    override fun getItemCount() = weapons.size

    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {
            holder.name.setText(weapons[position].name)
            holder.criteria.setText(weapons[position].cardRestriction)
            holder.description.setText(weapons[position].description)
            holder.effect.setText(weapons[position].effect)
    }
}
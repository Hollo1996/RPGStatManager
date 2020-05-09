package com.example.rpgstatmanager.view.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.character.D_Weapon
import com.example.rpgstatmanager.view.fragment.F_Move
import kotlinx.android.synthetic.main.fragment_move.*

class WeaponAdapter(
    val context: Context,
    val weapons: List<D_Weapon>
) : RecyclerView.Adapter<WeaponAdapter.WeaponViewHolder>() {

    class WeaponViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listMove: List<F_Move> = listOf(
            itemView.findViewById(R.id.move1OfWeapon),
            itemView.findViewById(R.id.move2OfWeapon),
            itemView.findViewById(R.id.move3OfWeapon),
            itemView.findViewById(R.id.move4OfWeapon),
            itemView.findViewById(R.id.move5OfWeapon),
            itemView.findViewById(R.id.move6OfWeapon),
            itemView.findViewById(R.id.move7OfWeapon),
            itemView.findViewById(R.id.move8OfWeapon)
        )
        val name:EditText = itemView.findViewById(R.id.nameOfMove)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.weapon, parent, false)
        return WeaponViewHolder(view)
    }

    override fun getItemCount() = weapons.size

    override fun onBindViewHolder(holder: WeaponViewHolder, position: Int) {
        holder.name.setText(weapons[position].name)
        for (i in holder.listMove.indices){
            holder.listMove[i].nameOfMove.setText(weapons[position].DMoves[i].name)
            holder.listMove[i].criteriaOfMove.setText(weapons[position].DMoves[i].cardRestriction)
            holder.listMove[i].descriptionOfMove.setText(weapons[position].DMoves[i].description)
            holder.listMove[i].effectOfMove.setText(weapons[position].DMoves[i].effect)
        }
    }
}
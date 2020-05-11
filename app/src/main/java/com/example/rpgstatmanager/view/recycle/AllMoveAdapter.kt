package com.example.rpgstatmanager.view.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.character.D_Move

class AllMoveAdapter(
    val context: Context,
    val moves: List<D_Move>
) : RecyclerView.Adapter<AllMoveAdapter.AllMoveViewHolder>()  {

    class AllMoveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvname: TextView = itemView.findViewById(R.id.nameOfMove)
            val tv: TextView = itemView.findViewById(R.id.tvAsDmRow)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllMoveAdapter.AllMoveViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.fragment_move, parent, false)
        return AllMoveViewHolder(view)
    }

    override fun getItemCount(): Int =moves.size

    override fun onBindViewHolder(holder: AllMoveAdapter.AllMoveViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

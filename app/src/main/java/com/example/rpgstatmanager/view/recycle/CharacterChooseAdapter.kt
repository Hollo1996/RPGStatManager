package com.example.rpgstatmanager.view.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.D_Character

class CharacterChooseAdapter(
    val context: Context,
    val adventure: List<D_Character>
) : RecyclerView.Adapter<CharacterChooseAdapter.CharacterChooseViewHolder>() {

    var itemClickListener: CharacterChooserClickListener? = null

    inner class CharacterChooseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btname: Button = itemView.findViewById(R.id.btCharacterChoose)

        var character: D_Character? = null

        init {
            btname.setOnClickListener {
                character?.let { ch ->
                    itemClickListener?.onItemClick(ch)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterChooseAdapter.CharacterChooseViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_item_character_button, parent, false)
        return CharacterChooseViewHolder(view)
    }

    override fun getItemCount(): Int = adventure.size

    override fun onBindViewHolder(
        holder: CharacterChooseAdapter.CharacterChooseViewHolder,
        position: Int
    ) {
        holder.btname.setText(adventure[position].name)
    }

    interface CharacterChooserClickListener {
        fun onItemClick(character: D_Character)
    }

}
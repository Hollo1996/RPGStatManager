package com.example.rpgstatmanager.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.character.D_Move
import kotlinx.android.synthetic.main.fragment_move.*

class F_Move : Fragment() {

    public var move: D_Move? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = ArrayAdapter.createFromResource(
            context ?: throw Error("No context"),
            R.array.moveType,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        typeOfMove.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_move, container, false)
    }
}

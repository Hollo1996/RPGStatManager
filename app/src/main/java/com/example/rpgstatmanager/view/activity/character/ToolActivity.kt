package com.example.rpgstatmanager.view.activity.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.character.ToolPresenter
import com.example.rpgstatmanager.screen.character.ToolScreen
import com.example.rpgstatmanager.view.recycle.RaceAdapter
import com.example.rpgstatmanager.view.recycle.ToolAdapter
import kotlinx.android.synthetic.main.activity_tool.*
import kotlinx.android.synthetic.main.row_item_tool.*
import javax.inject.Inject

class ToolActivity : AppCompatActivity(), ToolScreen {

    @Inject
    lateinit var presenter : ToolPresenter
    lateinit var adapter: ToolAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_tool)

        adapter=ToolAdapter(this,presenter.list() )
        listOfTools.adapter=adapter
        listOfTools.layoutManager = LinearLayoutManager(this)

    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }
    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }
}

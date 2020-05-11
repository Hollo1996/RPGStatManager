package com.example.rpgstatmanager.view.activity.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.character.StatPresenter
import com.example.rpgstatmanager.screen.character.StatScreen
import kotlinx.android.synthetic.main.activity_stat.*
import javax.inject.Inject

class StatActivity : AppCompatActivity(), StatScreen {

    @Inject
    lateinit var presenter : StatPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_stat)

        val list=presenter.list() //stregth, sense, speed, memory, agility, resistence

        etAgility.setText(list.get(4).value)
        etMemory.setText(list.get(3).value)
        etResistence.setText(list.get(5).value)
        etPerSense.setText(list.get(1).value)
        etSpeed.setText(list.get(2).value)
        etStrength.setText(list.get(0).value)

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

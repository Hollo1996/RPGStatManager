package com.example.rpgstatmanager.view.activity.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.character.MoveTypePresenter
import com.example.rpgstatmanager.screen.character.MoveTypeScreen
import kotlinx.android.synthetic.main.activity_move_base.*
import javax.inject.Inject

class MoveTypeActivity : AppCompatActivity(), MoveTypeScreen {

    @Inject
    lateinit var presenter : MoveTypePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_move_base)

        val list=presenter.list()

        etLift.setText(list.get(0).value)
        etDisarm.setText(list.get(1).value)
        etPerStrike.setText(list.get(2).value)
        etBlock.setText(list.get(3).value)
        etDodge.setText(list.get(4).value)
        etTarget.setText(list.get(5).value)
        etMove.setText(list.get(6).value)
        etReact.setText(list.get(7).value)
        etThrow.setText(list.get(8).value)
        etSearch.setText(list.get(9).value)
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

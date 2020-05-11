package com.example.rpgstatmanager.view.activity.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.character.RacePresenter
import com.example.rpgstatmanager.screen.character.RaceScreen
import com.example.rpgstatmanager.view.recycle.RaceAdapter
import kotlinx.android.synthetic.main.activity_race.*
import javax.inject.Inject

class RaceActivity : AppCompatActivity(), RaceScreen {

    @Inject
    lateinit var presenter : RacePresenter
    lateinit var adapter: RaceAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_race)

        val race=presenter.get()
        adapter=RaceAdapter(this, race.DAbilities)
        rvAbility.adapter=adapter

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

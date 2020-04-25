package com.example.rpgstatmanager.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.AdventureCreatorPresenter
import com.example.rpgstatmanager.screen.AdventureCreatorScreen
import javax.inject.Inject

class AdventureCreatorActivity : AppCompatActivity(), AdventureCreatorScreen {

    @Inject
    lateinit var presenter : AdventureCreatorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_adventure_creator)
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

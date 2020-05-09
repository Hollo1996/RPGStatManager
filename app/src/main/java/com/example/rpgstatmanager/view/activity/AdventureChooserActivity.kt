package com.example.rpgstatmanager.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.AdventureChooserPresenter
import com.example.rpgstatmanager.screen.AdventureChooserScreen
import javax.inject.Inject

class AdventureChooserActivity : AppCompatActivity(), AdventureChooserScreen {


    @Inject
    lateinit var presenter : AdventureChooserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_adventure_chooser)
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

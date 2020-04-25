package com.example.rpgstatmanager.view.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.character.EmotionModifierPresenter
import com.example.rpgstatmanager.screen.character.EmotionModifierScreen
import javax.inject.Inject

class EmotionModifierActivity : AppCompatActivity(), EmotionModifierScreen {

    @Inject
    lateinit var presenter : EmotionModifierPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_emotion)
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

package com.example.rpgstatmanager.view.activity.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.character.D_EmotionModifier
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.character.EmotionModifierPresenter
import com.example.rpgstatmanager.screen.character.EmotionModifierScreen
import kotlinx.android.synthetic.main.activity_emotion.*
import javax.inject.Inject

class EmotionModifierActivity : AppCompatActivity(), EmotionModifierScreen {

    @Inject
    lateinit var presenter: EmotionModifierPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_emotion)

        val list=presenter.list() //1happiness 2fear 3anger 4disgust 5sadness 6comfusoin
       /* ethappyposit1.setText(list.get(1).modifiers.get("stregth")!!)
        ethappyposit2.setText(list.get(1).modifiers.get("speed")!!)
        tvHappinessTitle.setOnClickListener {
            if (list.get(1))
                presenter.turnOn("happiness")
            else
                presenter.turnOff("happiness")

        }*/
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

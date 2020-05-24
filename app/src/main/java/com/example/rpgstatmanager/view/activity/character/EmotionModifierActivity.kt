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

        val list=presenter.list()//1happiness 2fear 3anger 4disgust 5sadness 6comfusoin

        ethappyposit1.setText(list.get(0).modifiers.get("stregth")!!)
        ethappyposit2.setText(list.get(0).modifiers.get("speed")!!)
        ethappyposit1.setText(list.get(0).modifiers.get("sense")!!)
        ethappynegat2.setText(list.get(0).modifiers.get("agility")!!)

        etfearposit1.setText(list.get(1).modifiers.get("stregth")!!)
        etfearposit2.setText(list.get(1).modifiers.get("speed")!!)
        etfearposit1.setText(list.get(1).modifiers.get("sense")!!)
        etfearnegat2.setText(list.get(1).modifiers.get("agility")!!)

        etangerposit1.setText(list.get(2).modifiers.get("stregth")!!)
        etangerposit2.setText(list.get(2).modifiers.get("speed")!!)
        etangerposit1.setText(list.get(2).modifiers.get("sense")!!)
        etangernegat2.setText(list.get(2).modifiers.get("agility")!!)

        etdisposit1.setText(list.get(3).modifiers.get("stregth")!!)
        etdisposit2.setText(list.get(3).modifiers.get("speed")!!)
        etdisposit1.setText(list.get(3).modifiers.get("sense")!!)
        etdisnegat2.setText(list.get(3).modifiers.get("agility")!!)

        etsadposit1.setText(list.get(4).modifiers.get("stregth")!!)
        etsadposit2.setText(list.get(4).modifiers.get("speed")!!)
        etsadposit1.setText(list.get(4).modifiers.get("sense")!!)
        etsadnegat2.setText(list.get(4).modifiers.get("agility")!!)

        etcomposit1.setText(list.get(5).modifiers.get("stregth")!!)
        etcomposit2.setText(list.get(5).modifiers.get("speed")!!)
        etcomposit1.setText(list.get(5).modifiers.get("sense")!!)
        etcomnegat2.setText(list.get(5).modifiers.get("agility")!!)
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

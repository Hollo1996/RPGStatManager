package com.example.rpgstatmanager.view.activity.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.character.PersonalityTypePresenter
import com.example.rpgstatmanager.screen.character.PersonalityTypeScreen
import kotlinx.android.synthetic.main.activity_persionality.*
import javax.inject.Inject

class PersonalityTypeActivity : AppCompatActivity(), PersonalityTypeScreen {

    @Inject
    lateinit var presenter : PersonalityTypePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_persionality)

        val list=presenter.get()

        etPerSense.setText(list.observent)
        etEmotion.setText(list.feeling)
        etExtroverted.setText(list.extrovert)
        etIntrovert.setText(list.introvert)
        etIntuition.setText(list.intuitive)
        etJudging.setText(list.judging)
        etPerceiving.setText(list.assertive)
        etThinking.setText(list.thinking)

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

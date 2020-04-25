package com.example.rpgstatmanager.view.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.presenter.character.PersonalityTypePresenter
import com.example.rpgstatmanager.screen.character.PersonalityTypeScreen
import javax.inject.Inject

class PersonalityTypeActivity : AppCompatActivity(), PersonalityTypeScreen {

    @Inject
    lateinit var presenter : PersonalityTypePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persionality)
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

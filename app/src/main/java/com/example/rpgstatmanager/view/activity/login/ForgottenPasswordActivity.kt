package com.example.rpgstatmanager.view.activity.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.login.ForgottenPasswordPresenter
import com.example.rpgstatmanager.screen.login.ForgottenPasswordScreen
import javax.inject.Inject

class ForgottenPasswordActivity : AppCompatActivity(), ForgottenPasswordScreen {

    @Inject
    lateinit var presenter : ForgottenPasswordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_forgotten_password)
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

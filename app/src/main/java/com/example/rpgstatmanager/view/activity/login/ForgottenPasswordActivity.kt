package com.example.rpgstatmanager.view.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.login.ForgottenPasswordPresenter
import com.example.rpgstatmanager.screen.login.ForgottenPasswordScreen
import kotlinx.android.synthetic.main.activity_forgotten_password.*
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class ForgottenPasswordActivity : AppCompatActivity(), ForgottenPasswordScreen {

    @Inject
    lateinit var presenter : ForgottenPasswordPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_forgotten_password)

        btForgottenSend.setOnClickListener {
            if(!presenter.sendReset(etUserName.text.toString()))
                Toast.makeText(
                    this, "Wrong name or password",
                    Toast.LENGTH_LONG
                ).show()
            startActivity(Intent(this,LoginActivity::class.java))
        }
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

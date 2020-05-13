@file:Suppress("DEPRECATION")

package com.example.rpgstatmanager.view.activity.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.login.LoginPresenter
import com.example.rpgstatmanager.screen.login.LoginScreen
import com.example.rpgstatmanager.view.activity.AdventureChooserActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginScreen {

    @Inject
    lateinit var presenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injector.inject(this)

        setContentView(R.layout.activity_login)

        btForgotten.setOnClickListener{
            startActivity(Intent(this,ForgottenPasswordActivity::class.java))
        }

        btLogin.setOnClickListener {
            if(!presenter.validate(etUsername.text.toString(),etPassword.text.toString()))
                Toast.makeText(
                    this, "Wrong name or password",
                    Toast.LENGTH_LONG
                ).show()
            val i=Intent(this,AdventureChooserActivity::class.java)
            //i.putExtra(AdventureChooserActivity.PLAYER_ID,)
            startActivity(i)
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

package com.example.rpgstatmanager.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.MainPresenter
import com.example.rpgstatmanager.screen.MainScreen
import com.example.rpgstatmanager.view.activity.login.LoginActivity
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainScreen {


    @Inject
    lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
        val myIntent = Intent(this@MainActivity, LoginActivity::class.java)
        //myIntent.putExtra("key", value) //Optional parameters
        this@MainActivity.startActivity(myIntent)
    }
    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }
}

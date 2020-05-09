package com.example.rpgstatmanager.view.activity.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.character.WeaponPresenter
import com.example.rpgstatmanager.screen.character.WeaponScreen
import com.example.rpgstatmanager.view.recycle.WeaponAdapter
import kotlinx.android.synthetic.main.activity_weapon.*
import javax.inject.Inject

class WeaponActivity : AppCompatActivity(),WeaponScreen {

    @Inject
    lateinit var presenter : WeaponPresenter

    lateinit var adapter:WeaponAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_weapon)

        adapter = WeaponAdapter(this,presenter.list())
        listOfWeapons.adapter = adapter
        listOfWeapons.layoutManager = LinearLayoutManager(this)
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

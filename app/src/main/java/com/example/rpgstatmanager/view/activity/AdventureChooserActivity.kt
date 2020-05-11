package com.example.rpgstatmanager.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.D_Adventure
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.AdventureChooserPresenter
import com.example.rpgstatmanager.screen.AdventureChooserScreen
import com.example.rpgstatmanager.view.recycle.AdventureAdapter
import kotlinx.android.synthetic.main.activity_adventure_chooser.*
import javax.inject.Inject

class AdventureChooserActivity : AppCompatActivity(), AdventureChooserScreen,AdventureAdapter.AdventureClickListener {

    @Inject
    lateinit var presenter: AdventureChooserPresenter
    lateinit var  adapter:AdventureAdapter

   /* companion object {
        const val PLAYER_ID = "PLAYER_ID"
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_adventure_chooser)

        adapter=AdventureAdapter(this,presenter.list())
        adapter.itemClickListener=this
        rvAdventure.adapter=adapter

        fbAddAdventure.setOnClickListener { startActivity(Intent(this,AdventureCreatorActivity::class.java)) }
    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }

    override fun onItemClick(adventure: D_Adventure) {
        val i= Intent(this, CharacterChooserActivity::class.java)
        presenter.choose(adventure.id)
        startActivity(i)
    }
}

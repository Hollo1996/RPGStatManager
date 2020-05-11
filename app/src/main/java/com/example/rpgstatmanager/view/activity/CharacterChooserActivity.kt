package com.example.rpgstatmanager.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.D_Character
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.AdventureChooserPresenter
import com.example.rpgstatmanager.presenter.CharacterChooserPresenter
import com.example.rpgstatmanager.screen.CharacterChooserScreen
import com.example.rpgstatmanager.view.recycle.CharacterChooseAdapter
import kotlinx.android.synthetic.main.activity_character_chooser.*
import javax.inject.Inject

class CharacterChooserActivity : AppCompatActivity(), CharacterChooserScreen,CharacterChooseAdapter.CharacterChooserClickListener {

    @Inject
    lateinit var presenter : CharacterChooserPresenter
    lateinit var  adapter: CharacterChooseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_character_chooser)

        adapter= CharacterChooseAdapter(this,presenter.list())
        adapter.itemClickListener=this
        rcCharacterChoosing.adapter=adapter

    }

    override fun onStart() {
        super.onStart()
        presenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachScreen()
    }


    override fun onItemClick(character: D_Character) {
        val i= Intent(this, CharacterActivity::class.java)
        presenter.choose(character.id)
        startActivity(i)
    }

}

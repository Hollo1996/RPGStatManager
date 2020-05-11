package com.example.rpgstatmanager.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.model.D_Adventure
import com.example.rpgstatmanager.module.injector
import com.example.rpgstatmanager.presenter.AdventureCreatorPresenter
import com.example.rpgstatmanager.screen.AdventureCreatorScreen
import com.example.rpgstatmanager.view.recycle.AdventureCreatePlayersAdapter
import kotlinx.android.synthetic.main.activity_adventure_creator.*
import javax.inject.Inject

class AdventureCreatorActivity : AppCompatActivity(), AdventureCreatorScreen {

    @Inject
    lateinit var presenter: AdventureCreatorPresenter
    lateinit var adapter: AdventureCreatePlayersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        setContentView(R.layout.activity_adventure_creator)

        adapter = AdventureCreatePlayersAdapter(this)
        rvAdventureCreatorPlayers.adapter = adapter

        btComplete.setOnClickListener {
            var newAdventur: D_Adventure = D_Adventure(
                id="",
                name = etAdventureName.text.toString(),
                icon = spAdventureChoose.toString(),
                gameCharacters =adapter.adventure,
                is_gm = false
            )
            presenter.save(newAdventur)

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

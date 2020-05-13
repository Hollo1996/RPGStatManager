package com.example.rpgstatmanager.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rpgstatmanager.R
import com.example.rpgstatmanager.interactor.PathTracker
import com.example.rpgstatmanager.presenter.CharacterChooserPresenter
import com.example.rpgstatmanager.view.activity.character.*
import kotlinx.android.synthetic.main.activity_character.*
import javax.inject.Inject

class CharacterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        tvCharacterTitle.setText(PathTracker.character.name)
        btAbility.setOnClickListener { startActivity(Intent(this, RaceActivity::class.java)) }
        btEmotion.setOnClickListener {startActivity(Intent(this, EmotionModifierActivity::class.java)) }
        btMove.setOnClickListener { startActivity(Intent(this, MoveTypeActivity::class.java)) }
        btPersonality.setOnClickListener { startActivity(Intent(this, PersonalityTypeActivity::class.java)) }
        btStat.setOnClickListener { startActivity(Intent(this, StatActivity::class.java)) }
        btWeapon.setOnClickListener { startActivity(Intent(this, WeaponActivity::class.java)) }
        btAllMove.setOnClickListener { startActivity(Intent(this,AllMovesActivity::class.java)) }
        btTool.setOnClickListener { startActivity(Intent(this,ToolActivity::class.java)) }
    }

}

package com.example.rpgstatmanager.interactor

import com.example.rpgstatmanager.swagger.client.model.S_Adventure
import com.example.rpgstatmanager.swagger.client.model.S_Race
import com.example.rpgstatmanager.swagger.client.model.S_Character


object PathTracker{
    lateinit var adventure : S_Adventure
    lateinit var character : S_Character
    lateinit var race : S_Race
}
package com.example.rpgstatmanager.interactor

import com.example.rpgstatmanager.swagger.client.model.Adventure
import com.example.rpgstatmanager.swagger.client.model.Race
import com.example.rpgstatmanager.swagger.client.model.Character


object PathTracker{
    lateinit var adventure : Adventure
    lateinit var character : Character
    lateinit var race : Race
}
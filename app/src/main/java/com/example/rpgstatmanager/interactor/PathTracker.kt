package com.example.rpgstatmanager.interactor

import com.example.rpgstatmanager.swagger.client.models.Adventure
import com.example.rpgstatmanager.swagger.client.models.Character
import com.example.rpgstatmanager.swagger.client.models.Race

object PathTracker{
    lateinit var adventure : Adventure
    lateinit var character : Character
    lateinit var race : Race
}
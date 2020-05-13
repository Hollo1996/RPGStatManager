package com.example.rpgstatmanager.mock

import com.example.rpgstatmanager.swagger.client.api.TokenApi
import retrofit2.Call
import kotlin.random.Random

class MockTokenApi : TokenApi {

    data class User(
        val id: String,
        val name: String,
        val password: String
    )

    val users = listOf<User>()

    companion object{
        val activeTokens = mutableMapOf<User, String>()
    }

    override fun getNewPassword(name: String?): Call<Void> = VoidCall()

    override fun getToken(name: String?, password: String?): Call<String> {
        if (name == null || password == null) return MockCall("")

        val user = users.find {
            it.name.compareTo(name) == 0 && it.password.compareTo(password) == 0
        } ?: return MockCall("")

        val code = Random.nextLong().toString()
        activeTokens[user] = code
        return MockCall(code)
    }
}
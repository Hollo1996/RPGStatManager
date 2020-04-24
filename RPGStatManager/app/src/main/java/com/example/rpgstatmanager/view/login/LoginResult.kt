package com.example.rpgstatmanager.view.login

import com.example.rpgstatmanager.view.login.LoggedInUserView

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)

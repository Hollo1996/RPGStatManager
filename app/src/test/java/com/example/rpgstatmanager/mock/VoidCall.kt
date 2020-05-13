package com.example.rpgstatmanager.mock

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class VoidCall : Call<Void> {
        override fun enqueue(callback: Callback<Void>?) {
        }

        @Throws(IOException::class)
        override fun execute(): Response<Void> {
            return Response.success(Void.TYPE.cast(this))
        }

        override fun isExecuted(): Boolean {
            return false
        }

        override fun cancel() {

        }

        override fun isCanceled(): Boolean {
            return false
        }

        override fun clone(): Call<Void> {
            return this
        }
}
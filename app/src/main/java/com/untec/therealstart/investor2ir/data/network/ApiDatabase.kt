package com.untec.therealstart.investor2ir.data.network

import io.reactivex.Single

interface ApiDatabase {
    fun getVerificationCode(email: String): Single<Void>
}
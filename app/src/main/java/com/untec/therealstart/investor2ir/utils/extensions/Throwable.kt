package com.untec.therealstart.investor2ir.utils.extensions

import com.google.gson.Gson
import com.untec.therealstart.investor2ir.utils.ServerError
import retrofit2.HttpException

internal fun Throwable.getHttpThrowable():HttpException?{
    return this as? HttpException
}
internal fun Throwable.getErrorCode():Int?{
    return if(this is HttpException){
        this.code()
    }else null

}
internal fun Throwable.getErrorMessage(): ServerError?{
    return if(this is HttpException){
        val gson = Gson()
        val topic = gson.fromJson(this.response()?.errorBody()?.string(), ServerError::class.java)
        topic
    }else null
}

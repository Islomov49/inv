package com.untec.therealstart.investor2ir.utils.extensions

import retrofit2.HttpException

internal fun Throwable.getHttpThrowable():HttpException?{
    return this as? HttpException
}
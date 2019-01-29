package com.lounah.usefulauthwithweather.core

interface Validator<Arg, ResultCode> {
    fun verify(arg: Arg) : ResultCode
}
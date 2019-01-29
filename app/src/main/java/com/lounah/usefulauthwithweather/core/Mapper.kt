package com.lounah.usefulauthwithweather.core

interface Mapper<From, To> {
    fun map(arg: From): To

    fun map(args: List<From>): List<To> {
        return args.map { map(it) }
    }
}
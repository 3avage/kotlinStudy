package com.example.testkotlin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
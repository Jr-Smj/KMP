package com.example.kmpapiapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
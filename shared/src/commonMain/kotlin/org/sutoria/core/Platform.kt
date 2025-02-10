package org.sutoria.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
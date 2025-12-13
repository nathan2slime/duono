package org.duonapp.duonapp

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Jhonathan, ${platform.name}!"
    }
}
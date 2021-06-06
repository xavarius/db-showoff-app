package com.maciejmalak.domain.models

data class User(
    val name: String,
    val surname: String,
    val age: Int,
    val gender: Gender,
    val address: Address
)

enum class Gender(val type: String) {
    MAN("man"),
    WOMAN("woman"),
    OTHER("other")
}

data class Address(val number: Int, val street: String, val city: String, val country: String)
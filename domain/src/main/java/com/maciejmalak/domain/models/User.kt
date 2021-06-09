package com.maciejmalak.domain.models

import com.google.gson.Gson

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

data class Address(val number: Int, val street: String, val city: String, val country: String) {
    // Not going to do much work with Gson so left hardcoded here.
    // It might be moved to a separate module (abstraction layer) with Gson injected there
    // for full control over how we map to/from JSON (which lib is used in this case)
    override fun toString(): String = Gson().toJson(this)

    companion object {
        fun buildAddressFromJson(jsonString: String): Address =
            Gson().fromJson(jsonString, Address::class.java)
    }
}

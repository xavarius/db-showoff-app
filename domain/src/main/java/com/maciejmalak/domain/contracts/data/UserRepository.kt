package com.maciejmalak.domain.contracts.data

import com.maciejmalak.domain.models.User

/*
A contract doesn't reveal implementation details of a data source behind it.
Methods names are simple, yet universal.
 */
interface UserRepository {
    fun put(vararg users: User): User
    fun getAll(): List<User>
    fun get(vararg users: User): User
    fun deleteAll(): Boolean
    fun delete(vararg users: User): Boolean
    fun update(vararg users: User): List<User>
}

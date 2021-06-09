package com.maciejmalak.domain.contracts.data

import com.maciejmalak.domain.models.User

/*
A contract doesn't reveal implementation details of a data source behind it.
Methods names are simple, yet universal.

At a later step decided to go with coroutines - thus adding suspend keyword.
Let's make those methods "main-thread-safe" inside also.
 */
interface UserRepositoryApi {
    suspend fun put(vararg users: User): User
    suspend fun getAll(): List<User>
    suspend fun get(vararg users: User): User
    suspend fun deleteAll(): Boolean
    suspend fun delete(vararg users: User): Boolean
    suspend fun update(vararg users: User): List<User>
}

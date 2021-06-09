package com.maciejmalak.data.db

import com.maciejmalak.domain.contracts.data.UserRepositoryApi
import com.maciejmalak.domain.models.User

class UserRepository : UserRepositoryApi {
    override suspend fun put(vararg users: User): User {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun get(vararg users: User): User {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun delete(vararg users: User): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun update(vararg users: User): List<User> {
        TODO("Not yet implemented")
    }
}
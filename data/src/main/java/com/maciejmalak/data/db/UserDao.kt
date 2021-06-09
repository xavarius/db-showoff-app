package com.maciejmalak.data.db

import androidx.room.*

@Dao
interface UserDao {
    @Delete
    fun delete(vararg users: UserDto) : Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: UserDto)

    @Update
    fun update(vararg users: UserDto)

    @Query("SELECT * FROM users")
    fun getAll() : List<UserDto>

    @Query("SELECT * FROM users WHERE first_name LIKE :name AND surname LIKE :surname LIMIT 1")
    fun get(name: String, surname: String ) : UserDto

}

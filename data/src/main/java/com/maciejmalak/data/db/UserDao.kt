package com.maciejmalak.data.db

import androidx.room.*

@Dao
interface UserDao {
    @Delete
    fun delete(vararg users: User) : Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: User)

    @Update
    fun update(vararg users: User)

    @Query("SELECT * FROM users")
    fun getall() : List<User>

    @Query("SELECT * FROM users WHERE first_name LIKE :name AND surname LIKE :surname LIMIT 1")
    fun get(name: String, surname: String ) : User

}

package com.maciejmalak.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class Db : RoomDatabase() {
    abstract fun usersDao(): UserDao
}

package com.maciejmalak.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * All of the implementation details hidden inside one, centralised module
 */
@Database(entities = [User::class], version = 1)
abstract class Db : RoomDatabase() {
    abstract fun usersDao(): UserDao

    object DbInitializer {
        private const val DB_NAME = "application_database"
        private var instance: Db? = null

        fun getInstance(context: Context): Db =
            instance ?: buildDB(context).also { instance = it }

        fun getUserDao(context: Context) = getInstance(context).usersDao()

        private fun buildDB(context: Context): Db =
            Room.databaseBuilder(context, Db::class.java, DB_NAME).build()
    }
}

package com.maciejmalak.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class Db : RoomDatabase() {
    abstract fun usersDao(): UserDao

    object DbInitializer {
        private const val DB_NAME = "application_database"
        private var instance: Db? = null

        fun getInstance(context: Context): Db =
            instance ?: buildDB(context).also { instance = it }


        private fun buildDB(context: Context): Db =
            Room.databaseBuilder(context, Db::class.java, DB_NAME).build()
    }
}

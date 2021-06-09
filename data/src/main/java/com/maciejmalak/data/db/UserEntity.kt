package com.maciejmalak.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "users", primaryKeys = ["name", "surname"])
data class UserDto(
    @ColumnInfo(name = "first_name") val name: String?,
    @ColumnInfo(name = "surname") val surname: String?,
    val age: Int,
    val gender: String?,
    val address: String?
)

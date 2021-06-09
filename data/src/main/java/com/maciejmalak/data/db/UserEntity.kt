package com.maciejmalak.data.db

import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.maciejmalak.domain.models.Address
import com.maciejmalak.domain.models.Address.Companion.buildAddressFromJson
import com.maciejmalak.domain.models.Gender
import com.maciejmalak.domain.models.User

@Entity(tableName = "users", primaryKeys = ["name", "surname"])
data class UserDto(
    @ColumnInfo(name = "first_name") val name: String?,
    @ColumnInfo(name = "surname") val surname: String?,
    val age: Int,
    val gender: String?,
    // Let's have a small difference between domain and data
    // to show case that data model can vary between layers and it's a good thing
    // especially when API is bloated with dummy fields
    val address: String?
)

/**
 * Not using interface with generics for all Mappers - it's an overkill here.
 * We have just ONE case to showcase here.
 */
class UserDtoMapper {
    fun mapFromDomainObject(user: User): UserDto = UserDto(
        user.name,
        user.surname,
        user.age,
        user.gender.type,
        user.address.toString()
    )

    /**
     * It might be an extension function but 1. separation of concerns between domain and data is needed
     * also having a small, separate module for all User mapping is maintainable/testable in the long term
     *
     * Also, one could argue that Gender mapping is a part of the business logic. It could be.
     * We don't have more rules here than "if not present set to default" so IMHO it could be left here for simplicity
     */
    fun mapToDomainObject(userDto: UserDto): User {
        val fallbackValue = ""

        val gender = try {
            userDto.gender?.let { Gender.valueOf(it) } ?: Gender.OTHER
        } catch (exception: Exception) {
            Log.e(this::class.simpleName, "mapToDomainObject: $exception")
            Gender.OTHER
        }

        val address = when {
            userDto.address.isNullOrEmpty() -> Address(
                0,
                fallbackValue,
                fallbackValue,
                fallbackValue
            )
            else -> buildAddressFromJson(userDto.address)
        }

        return User(
            userDto.name ?: fallbackValue,
            userDto.surname ?: fallbackValue,
            userDto.age,
            gender,
            address
        )
    }
}

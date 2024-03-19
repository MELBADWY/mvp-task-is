package com.example.taskmvp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao
    abstract fun saveUserProfile(model: UserProfileModel)
    abstract fun getUserProfile(): Any
    fun getUserProfileDao() {

    }
}

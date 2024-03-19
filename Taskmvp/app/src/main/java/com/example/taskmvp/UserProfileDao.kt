package com.example.taskmvp

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


interface UserProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userProfile: UserProfile)

    @Query("SELECT * FROM user_profile WHERE id = 1")
    fun getUserProfile(): UserProfile
}
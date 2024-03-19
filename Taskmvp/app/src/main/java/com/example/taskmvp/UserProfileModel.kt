package com.example.taskmvp

data class UserProfileModel(
    var name: String = "", var address: String = "", var phoneNumber: String = ""
)
data class UserProfile(val name: String, val address: String, val phoneNumber: String)

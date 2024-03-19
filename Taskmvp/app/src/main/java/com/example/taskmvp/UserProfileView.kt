package com.example.taskmvp

interface UserProfileView {
    fun showProgress()
    fun hideProgress()
    fun setName(name: String)
    fun setAddress(address: String)
    fun setPhoneNumber(phoneNumber: String)
    fun onError(message: String)
}

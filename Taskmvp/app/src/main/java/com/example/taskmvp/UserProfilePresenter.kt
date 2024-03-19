package com.example.taskmvp

interface UserProfilePresenter {
    fun onStart()
    fun onNameChanged(name: String)
    fun onAddressChanged(address: String)
    fun onPhoneNumberChanged(phoneNumber: String)
    fun onSaveClicked()
}

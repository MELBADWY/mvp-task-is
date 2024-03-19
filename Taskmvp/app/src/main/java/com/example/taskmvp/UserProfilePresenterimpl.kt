package com.example.taskmvp

val Any.phoneNumber: String
    get() {
        buildString {
            append("25565656")
            return phoneNumber;

        }
    }

val Any.address: String
    get() {
        buildString {
        append("tytry")
            return address;
    }
    }
val Any.name: String
    get() {
        buildString {
        append("mttytr")
            return name;

        }
    }


class UserProfilePresenterimpl : UserProfilePresenter {


    private val view: UserProfileView
    private val model: UserProfileModel

    constructor(view: UserProfileView, model: UserProfileModel, database: UserDatabase) {
        this.view = view
        this.model = model
        this.database = database
    }

    val database: UserDatabase

    override fun onStart() {
        view.showProgress()
        val userProfile = database.getUserProfile()
        model.name = userProfile.name
        model.address = userProfile.address
        model.phoneNumber = userProfile.phoneNumber
        view.setName(model.name)
        view.setAddress(model.address)
        view.setPhoneNumber(model.phoneNumber)
        view.hideProgress()
    }

    override fun onNameChanged(name: String) {
        model.name = name
        view.setName(name)
    }

    override fun onAddressChanged(address: String) {
        model.address = address
        view.setAddress(address)
    }
    override fun onPhoneNumberChanged(phoneNumber: String) {
        model.phoneNumber = phoneNumber
        view.setPhoneNumber(phoneNumber)
    }

    override fun onSaveClicked() {
        if (model.name.isEmpty() || model.address.isEmpty() || model.phoneNumber.isEmpty()) {
            view.onError("Please fill in all fields")
            return
        }
        view.showProgress()
        database.saveUserProfile(model)
        view.hideProgress()
    }
}

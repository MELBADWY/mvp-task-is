package com.example.taskmvp

import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room


/*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

*/





/*
class UserProfilePresenterImpl(private val view: UserProfileView, private val model: UserProfileModel, private val database: UserDatabase) : UserProfilePresenter {

    override fun onStart() {
        view.setName(model.name)
        view.setAddress(model.address)
        view.setPhoneNumber(model.phoneNumber)
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

class UserProfileActivity : AppCompatActivity(), UserProfileView {

    private lateinit var presenter: UserProfilePresenter
    private lateinit var database: UserDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        database = UserDatabase.getInstance(this)

        presenter = UserProfilePresenterImpl(this, database.getUserProfile(), database)

        presenter.onStart()
    }

    override fun showProgress() {
        // Show progress dialog or progress bar
    }

    override fun hideProgress() {
        // Hide progress dialog or progress bar
    }

    override fun setName(name: String) {
        // Set the name in the UI
    }

    override fun setAddress(address: String) {
        // Set the address in the UI
    }

    override fun setPhoneNumber(phoneNumber: String) {
        // Set the phone number in the UI
    }

    override fun onError(message: String) {
        // Show error message in the UI
    }
}

object UserDatabase {
        fun getCurrentUser(): UserProfileModel {
            return UserProfileModel("Hossam","mansoura","01012152332")
        }
    }
}
*/

class UserProfilePresenterImpl(private val view: UserProfileView, private val model: UserProfileModel, private val database: UserDatabase) : UserProfilePresenter {

    override fun onStart() {
        view.showProgress()
        val userProfile = database.getUserProfileDao().getUserProfile()
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
        val userProfile = UserProfile(model.name, model.address, model.phoneNumber)
        database.getUserProfileDao().insert(userProfile)
        view.hideProgress()
    }
}

private fun Any.getUserProfile() {
    val name: String;
    val address: String;
    val phoneNumber: String;
}

private fun Any.insert(userProfile: UserProfile) {
    TODO("Not yet implemented")
}

private fun Any.onCreate() {
    TODO("Not yet implemented")
}

class MyApplication : AppCompatActivity() {

    lateinit var database: UserDatabase

    fun onCreate() {
        onCreate()
        val applicationContext = null
        database = applicationContext?.let {
            return@let Room.databaseBuilder(
                it,
                UserDatabase::class.java,
                "user_database"
            ).build()
        }!!
    }
}

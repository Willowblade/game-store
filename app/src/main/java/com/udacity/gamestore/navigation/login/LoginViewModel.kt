package com.udacity.gamestore.navigation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// TODO I think the view model may be super overkill here...
class LoginViewModel : ViewModel() {
    val _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email

    val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    fun updateEmail(string: String) {
        this._email.value = string
    }

    fun updatePassword(string: String) {
        this._password.value = string
    }
}
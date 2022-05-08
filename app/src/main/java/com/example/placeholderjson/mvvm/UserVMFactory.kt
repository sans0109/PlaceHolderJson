package com.example.placeholderjson.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserVMFactory(val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        UserViewModel(userRepository) as T

}
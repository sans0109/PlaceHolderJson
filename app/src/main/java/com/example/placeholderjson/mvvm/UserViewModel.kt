package com.example.placeholderjson.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.placeholderjson.models.Root
import kotlinx.coroutines.launch

class UserViewModel(val userRepository: UserRepository) : ViewModel() {

    val myResponse: MutableLiveData<List<Root>> = MutableLiveData()

    fun getUser() {
        viewModelScope.launch {
            val response = userRepository.getUser()
            myResponse.value = response
        }
    }
}
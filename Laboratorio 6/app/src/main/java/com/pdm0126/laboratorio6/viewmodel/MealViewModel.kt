package com.pdm0126.laboratorio6.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.laboratorio6.data.model.Meal
import com.pdm0126.laboratorio6.data.repository.MealRepository
import com.pdm0126.laboratorio6.data.repository.MealRepositoryImpl
import kotlinx.coroutines.launch

class MealViewModel : ViewModel () {

    private val repository: MealRepository = MealRepositoryImpl()

    var meals by mutableStateOf<List<Meal>>(emptyList())
        private set
    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)
        private set


    fun fetchMeals(letter: String) {
        viewModelScope.launch {
            isLoading = true
            error = null
            repository.getMeals(letter)
                .onSuccess { meals = it }
                .onFailure { error = it.message }
            isLoading = false
        }
    }
}
package com.pdm0126.laboratorio6.data.repository

import com.pdm0126.laboratorio6.data.model.Meal

interface MealRepository {
    suspend fun getMeals(letter: String): Result<List<Meal>>
}
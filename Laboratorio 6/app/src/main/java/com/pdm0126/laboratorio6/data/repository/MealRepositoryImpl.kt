package com.pdm0126.laboratorio6.data.repository

import com.pdm0126.laboratorio6.data.api.KtorClient
import com.pdm0126.laboratorio6.data.api.Meal.MealResponse
import com.pdm0126.laboratorio6.data.model.Meal
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MealRepositoryImpl : MealRepository {

    override suspend fun getMeals(letter: String): Result<List<Meal>> {
        return try {
            val response: MealResponse = KtorClient.httpClient
                .get("search.php") {
                    parameter("s", letter)
                }.body()

            val meals = response.meals.map { dto ->
                Meal(
                    id = dto.id,
                    name = dto.name,
                    categoria = dto.categoria,
                    area = dto.area,
                    imagen = dto.imagenMedium
                )
            } ?: emptyList()

            Result.success(meals)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
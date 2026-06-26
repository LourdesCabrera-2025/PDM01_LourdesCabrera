package com.pdm0126.laboratorio6.data.api.Meal

import com.pdm0126.laboratorio6.data.model.Meal
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealResponse(
    val meals: List<MealDto>
)


@Serializable
data class MealDto(
    @SerialName ("idMeal")
    val id: String,
    @SerialName("strMeal")
    val name: String,
    @SerialName("strCategory")
    val categoria: String,
    @SerialName("strArea")
    val area: String,
    @SerialName("strMealThumb")
    val imagen: String
) {
    val imagenSmall: String get() = "$imagen/small"
    val imagenMedium: String get() = "$imagen/medium"
    val imagenLarge: String get() = "$imagen/large"
}


fun MealDto.toModel() : Meal {
    return Meal (
        id = id,
        name = name,
        categoria = categoria,
        area = area,
        imagen = imagen
    )
}
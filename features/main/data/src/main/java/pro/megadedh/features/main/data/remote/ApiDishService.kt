package pro.megadedh.features.main.data.remote

import pro.megadedh.features.main.data.remote.models.response.DishCategoriesResponse
import pro.megadedh.features.main.data.remote.models.response.DishesResponse
import retrofit2.http.GET

interface ApiDishService {
    @GET("")
    suspend fun getAllCategories(): DishCategoriesResponse

    @GET("")
    suspend fun getDishesUseCase(): DishesResponse
}

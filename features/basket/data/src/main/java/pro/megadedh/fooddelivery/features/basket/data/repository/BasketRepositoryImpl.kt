package pro.megadedh.fooddelivery.features.basket.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import pro.megadedh.common.api.presentation.model.result.Dish
import pro.megadedh.fooddelivery.core.utils.dispatchers.DispatchersProvider
import pro.megadedh.fooddelivery.database.dao.BasketDao
import pro.megadedh.fooddelivery.database.entities.BasketItemEntity
import pro.megadedh.fooddelivery.features.basket.api.presentation.model.BasketItem
import pro.megadedh.fooddelivery.features.basket.domain.repository.BasketRepository
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(
    private val dispatchersProvider: DispatchersProvider,
    private val basketDao: BasketDao,
) : BasketRepository {

    override suspend fun addDishInBasket(dish: Dish) = withContext(dispatchersProvider.io) {
        basketDao.insert(dish.mapToEntity())
    }


    override fun getBasket(): Flow<List<BasketItem>> {
        return basketDao.getAll()
            .flowOn(dispatchersProvider.io)
            .map { list ->
            list.map { it.mapToBasketItem() }
        }
    }

    private fun BasketItemEntity.mapToBasketItem() = BasketItem(
        id = id.toIntOrNull() ?: 0,
        name = name,
        price = price,
        weight = weight,
        quantity = quantity,
        imageUrl = imageUrl,
    )

    private fun Dish.mapToEntity() = BasketItemEntity(
        id = id.toString(),
        name = name,
        price = price,
        weight = weight,
        quantity = 42, //TODO
        imageUrl = imageUrl,
    )
}

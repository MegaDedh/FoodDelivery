package pro.megadedh.fooddelivery.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pro.megadedh.fooddelivery.database.entities.BasketItemEntity
import pro.megadedh.fooddelivery.database.entities.BasketItemEntity.Companion.TABLE_NAME

@Dao
interface BasketDao : BaseDao<BasketItemEntity> {

    @Query("SELECT * FROM $TABLE_NAME WHERE ${BasketItemEntity.Columns.ID}=:id")
    override suspend fun getById(id: String): BasketItemEntity?

    @Query("SELECT * FROM $TABLE_NAME WHERE ${BasketItemEntity.Columns.ID}=:id")
    override fun getByIdReactive(id: String): Flow<BasketItemEntity>

    @Query("SELECT * FROM $TABLE_NAME ORDER BY id ASC")
    override fun getAll(): Flow<List<BasketItemEntity>>

    @Query("DELETE FROM $TABLE_NAME WHERE ${BasketItemEntity.Columns.ID}=:id")
    override suspend fun deleteById(id: String)

    @Query("DELETE FROM $TABLE_NAME")
    override suspend fun clear()

    @Query("UPDATE $TABLE_NAME SET ${BasketItemEntity.Columns.QUANTITY} = ${BasketItemEntity.Columns.QUANTITY} + 1 WHERE ${BasketItemEntity.Columns.ID}=:id")
    suspend fun incrementQuantityById(id: String)

    @Query("UPDATE $TABLE_NAME SET ${BasketItemEntity.Columns.QUANTITY} = ${BasketItemEntity.Columns.QUANTITY} - 1 WHERE ${BasketItemEntity.Columns.ID}=:id")
    suspend fun decrementQuantityById(id: String)
}

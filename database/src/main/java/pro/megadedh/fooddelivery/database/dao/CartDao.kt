package pro.megadedh.fooddelivery.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pro.megadedh.fooddelivery.database.entities.CartEntity
import pro.megadedh.fooddelivery.database.entities.CartEntity.Companion.TABLE_NAME

@Dao
interface CartDao : BaseDao<CartEntity> {

    @Query("SELECT * FROM $TABLE_NAME WHERE ${CartEntity.Columns.ID}=:id")
    override suspend fun getById(id: String): CartEntity?

    @Query("SELECT * FROM $TABLE_NAME WHERE ${CartEntity.Columns.ID}=:id")
    override fun getByIdReactive(id: String): Flow<CartEntity>

    @Query("SELECT * FROM $TABLE_NAME ORDER BY id ASC")
    override fun getAll(): Flow<List<CartEntity>>

    @Query("DELETE FROM $TABLE_NAME WHERE ${CartEntity.Columns.ID}=:id")
    override suspend fun deleteById(id: String)

    @Query("DELETE FROM $TABLE_NAME")
    override suspend fun clear()
}

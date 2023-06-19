package pro.megadedh.fooddelivery.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow

interface BaseDao<E> {

    suspend fun getById(id: String): E?

    fun getByIdReactive(id: String): Flow<E>

    fun getAll(): Flow<List<E>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: E)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entityList: List<E>)

    @Delete
    suspend fun delete(entity: E)

    suspend fun deleteById(id: String)

    suspend fun clear()
}

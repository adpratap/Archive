package com.noreplypratap.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.noreplypratap.data.model.DArchive
import kotlinx.coroutines.flow.Flow

@Dao
interface ArchiveDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createArchive(dArchive: DArchive)

    @Query("SELECT * From archive_table")
    fun readArchive(): Flow<List<DArchive>>

    @Update
    suspend fun updateArchive(dArchive: DArchive)

    @Delete
    suspend fun deleteArchive(dArchive: DArchive)

}
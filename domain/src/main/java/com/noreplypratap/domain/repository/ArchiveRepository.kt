package com.noreplypratap.domain.repository

import com.noreplypratap.domain.model.Archive
import kotlinx.coroutines.flow.Flow

interface ArchiveRepository {

    //CRUD
    suspend fun createArchive(archive: Archive)
    fun readArchive(): Flow<List<Archive>>
    suspend fun updateArchive(archive: Archive)
    suspend fun deleteArchive(archive: Archive)

}
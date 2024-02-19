package com.noreplypratap.data.repository

import com.noreplypratap.data.mapper.toArchive
import com.noreplypratap.data.mapper.toDArchive
import com.noreplypratap.data.source.ArchiveDao
import com.noreplypratap.domain.model.Archive
import com.noreplypratap.domain.repository.ArchiveRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ArchiveRepositoryImpl@Inject constructor(private val archiveDao: ArchiveDao): ArchiveRepository {

    override suspend fun createArchive(archive: Archive) {
        archiveDao.createArchive(archive.toDArchive(true))
    }

    override fun readArchive(): Flow<List<Archive>> {
        return archiveDao.readArchive().map {
            it.map { dArchive ->
                dArchive.toArchive()
            }
        }
    }

    override suspend fun updateArchive(archive: Archive) {
        archiveDao.updateArchive(archive.toDArchive(true))
    }

    override suspend fun deleteArchive(archive: Archive) {
        archiveDao.deleteArchive(archive.toDArchive(false))
    }

}
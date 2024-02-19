package com.noreplypratap.domain.usecase

import com.noreplypratap.domain.model.Archive
import com.noreplypratap.domain.repository.ArchiveRepository
import javax.inject.Inject

class CreateArchiveUseCase@Inject constructor(private val archiveRepository: ArchiveRepository) {
    suspend operator fun invoke(archive: Archive) = archiveRepository.createArchive(archive)
}
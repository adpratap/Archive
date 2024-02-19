package com.noreplypratap.domain.usecase

import com.noreplypratap.domain.repository.ArchiveRepository
import javax.inject.Inject

class ReadArchiveUseCase@Inject constructor(private val archiveRepository: ArchiveRepository) {
    operator fun invoke() = archiveRepository.readArchive()
}
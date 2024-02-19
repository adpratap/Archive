package com.noreplypratap.domain.di

import com.noreplypratap.domain.repository.ArchiveRepository
import com.noreplypratap.domain.usecase.CreateArchiveUseCase
import com.noreplypratap.domain.usecase.DeleteArchiveUseCase
import com.noreplypratap.domain.usecase.ReadArchiveUseCase
import com.noreplypratap.domain.usecase.UpdateArchiveUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideCreateArchiveUseCase(archiveRepository: ArchiveRepository): CreateArchiveUseCase =
        CreateArchiveUseCase(archiveRepository)

    @Provides
    @Singleton
    fun provideReadArchiveUseCase(archiveRepository: ArchiveRepository): ReadArchiveUseCase =
        ReadArchiveUseCase(archiveRepository)

    @Provides
    @Singleton
    fun provideUpdateArchiveUseCase(archiveRepository: ArchiveRepository): UpdateArchiveUseCase =
        UpdateArchiveUseCase(archiveRepository)

    @Provides
    @Singleton
    fun provideDeleteArchiveUseCase(archiveRepository: ArchiveRepository): DeleteArchiveUseCase =
        DeleteArchiveUseCase(archiveRepository)

}
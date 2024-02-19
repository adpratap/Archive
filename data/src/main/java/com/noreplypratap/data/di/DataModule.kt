package com.noreplypratap.data.di

import android.app.Application
import com.noreplypratap.data.repository.ArchiveRepositoryImpl
import com.noreplypratap.data.source.ArchiveDao
import com.noreplypratap.data.source.ArchiveDatabase
import com.noreplypratap.domain.repository.ArchiveRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideArchiveDatabase(application: Application): ArchiveDatabase {
        return ArchiveDatabase.createArchiveDatabase(application)
    }

    @Provides
    @Singleton
    fun provideArchiveDao(archiveDatabase: ArchiveDatabase): ArchiveDao {
        return archiveDatabase.getArchiveDao()
    }

    @Provides
    @Singleton
    fun provideArchiveRepository(archiveDao: ArchiveDao): ArchiveRepository {
        return ArchiveRepositoryImpl(archiveDao)
    }

}
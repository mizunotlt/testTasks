package com.awaresiel.testtasks.di.module

import com.awaresiel.testtasks.models.AlbumsModels
import com.awaresiel.testtasks.models.SongsModels
import com.awaresiel.testtasks.repository.AlbumsRepository
import com.awaresiel.testtasks.repository.SongsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideAlbumsViewModels(repository: AlbumsRepository): AlbumsModels {
        return AlbumsModels(repository)
    }

    @Provides
    @Singleton
    fun provideSongsViewModels(repository: SongsRepository): SongsModels {
        return SongsModels(repository)
    }
}
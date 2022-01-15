package com.awaresiel.testtasks.di.module

import com.awaresiel.testtasks.api.AlbumsApi
import com.awaresiel.testtasks.api.SongsApi
import com.awaresiel.testtasks.repository.AlbumsRepository
import com.awaresiel.testtasks.repository.SongsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepositoryAlbums(api: AlbumsApi): AlbumsRepository {
        return AlbumsRepository(api)
    }

    @Provides
    fun provideRepositorySongs(api: SongsApi): SongsRepository {
        return SongsRepository(api)
    }


}
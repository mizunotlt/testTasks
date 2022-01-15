package com.awaresiel.testtasks.di.components

import com.awaresiel.testtasks.MainActivity
import com.awaresiel.testtasks.di.module.AppModule
import com.awaresiel.testtasks.di.module.NetworkModule
import com.awaresiel.testtasks.di.module.RepositoryModule
import com.awaresiel.testtasks.di.module.ViewModelModule
import com.awaresiel.testtasks.fragments.AlbumsViewFragment
import com.awaresiel.testtasks.fragments.SongsViewFragment
import com.awaresiel.testtasks.models.AlbumsModels
import com.awaresiel.testtasks.models.SongsModels
import dagger.Component
import dagger.Reusable
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
@Singleton
interface AppComponent{

    //Inject Activity
    fun inject(activity: MainActivity)

    //Inject Fragments
    fun inject(albumsFragment: AlbumsViewFragment)
    fun inject(songsViewFragment: SongsViewFragment)

    //Inject viewModels
    fun inject(albumsModels: AlbumsModels)
    fun inject(songsModels: SongsModels)

}
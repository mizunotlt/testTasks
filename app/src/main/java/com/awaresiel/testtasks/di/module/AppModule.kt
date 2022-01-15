package com.awaresiel.testtasks.di.module

import android.content.Context
import com.awaresiel.testtasks.TestTaskApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesApplicationContext(app: TestTaskApplication): Context = app.applicationContext

}
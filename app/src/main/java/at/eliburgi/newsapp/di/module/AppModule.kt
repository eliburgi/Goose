package at.eliburgi.newsapp.di.module

import android.app.Application
import at.eliburgi.newsapp.domain.scheduler.BaseScheduler
import at.eliburgi.newsapp.domain.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Elias on 16.12.2017.
 */
@Module
class AppModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideContext() = app

    @Singleton
    @Provides
    fun provideScheduler(): BaseScheduler = SchedulerProvider()
}
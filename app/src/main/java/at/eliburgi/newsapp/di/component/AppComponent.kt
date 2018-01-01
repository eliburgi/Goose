package at.eliburgi.newsapp.di.component

import at.eliburgi.newsapp.di.module.ApiModule
import at.eliburgi.newsapp.di.module.AppModule
import at.eliburgi.newsapp.di.module.DataModule
import at.eliburgi.newsapp.domain.repository.ArticleRepository
import at.eliburgi.newsapp.domain.scheduler.BaseScheduler
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Elias on 16.12.2017.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class, ApiModule::class))
interface AppComponent {

    fun scheduler(): BaseScheduler
    fun articleRepository(): ArticleRepository

}
package at.eliburgi.newsapp.di.module

import at.eliburgi.newsapp.di.scope.ViewScope
import at.eliburgi.newsapp.domain.repository.ArticleRepository
import at.eliburgi.newsapp.domain.scheduler.BaseScheduler
import at.eliburgi.newsapp.presentation.newsfeed.NewsFeedViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by Elias on 16.12.2017.
 */
@Module
class ViewModule {
    @ViewScope
    @Provides
    fun provideNewsFeedViewModelFactory(articleRepository: ArticleRepository, scheduler: BaseScheduler)
            = NewsFeedViewModelFactory(articleRepository, scheduler)
}
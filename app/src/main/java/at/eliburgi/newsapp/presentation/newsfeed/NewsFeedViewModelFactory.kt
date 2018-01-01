package at.eliburgi.newsapp.presentation.newsfeed

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import at.eliburgi.newsapp.di.scope.ViewScope
import at.eliburgi.newsapp.domain.repository.ArticleRepository
import at.eliburgi.newsapp.domain.scheduler.BaseScheduler
import javax.inject.Inject

/**
 * Created by Elias on 16.12.2017.
 */
@ViewScope
class NewsFeedViewModelFactory @Inject
constructor(private val articleRepository: ArticleRepository,
            private val schedulerProvider: BaseScheduler)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsFeedViewModel::class.java)) {
            return NewsFeedViewModel(articleRepository, schedulerProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class!")
    }
}
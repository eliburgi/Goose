package at.eliburgi.newsapp.presentation.newsfeed

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import at.eliburgi.newsapp.domain.ArticleRepository
import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.scheduler.BaseScheduler
import at.eliburgi.newsapp.presentation.base.Response

/**
 * Created by Elias on 15.12.2017.
 */
class NewsFeedViewModel(private val articleRepository: ArticleRepository,
                        private val schedulerProvider: BaseScheduler)
    : ViewModel() {

    private val newsFeed = MutableLiveData<Response<List<Article>>>()

    fun loadNewsFeed() {
        articleRepository.getTopArticles()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(this::updateNewsFeed, this::errorLoadingNewsFeed)
    }

    fun newsFeed(): LiveData<Response<List<Article>>> = newsFeed

    private fun updateNewsFeed(articles: List<Article>) {
        newsFeed.value = Response.success(articles)
    }

    private fun errorLoadingNewsFeed(error: Throwable) {
        newsFeed.value = Response.error(error)
    }

    override fun onCleared() {
        super.onCleared()
        // Dispose any rx subscribers.
    }
}
package at.eliburgi.newsapp.data.repository

import at.eliburgi.newsapp.data.exception.NoNetworkConnectionException
import at.eliburgi.newsapp.data.repository.source.ArticleSource
import at.eliburgi.newsapp.di.qualifier.Remote
import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.model.TopArticleRequest
import at.eliburgi.newsapp.domain.repository.ArticleRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton
import at.eliburgi.newsapp.data.util.NetworkManager


/**
 * Created by Elias on 16.12.2017.
 */
@Singleton
class ArticleRepositoryImpl @Inject constructor(@Remote private val remoteSource: ArticleSource,
                                                private val networkManager: NetworkManager)
    : ArticleRepository {

    // Store last refreshed in database or shared prefs?
    // For every request id store the current page as well as last refreshed.

    override fun getTopArticles(request: TopArticleRequest): Single<List<Article>> {
        // return from db if there are some
        // if has internet
        //     -> check if the last refresh is longer than 5 min
        //     -> if so, make api call and merge with db but debounce
        //     -> also make api call if forceRefresh is set
        return remoteSource.getTopArticles(request)
    }

    override fun getRecentArticles(): Single<List<Article>> {
        return remoteSource.getRecentArticles()
    }

    override fun fetchTopArticles(request: TopArticleRequest): Single<List<Article>> {
        if (!networkManager.isNetworkConnection()) {
            return Single.error(NoNetworkConnectionException())
        }
        return remoteSource.getTopArticles(request)
                .doOnSuccess { /* TODO: Insert into database + refresh last updated */ }
    }

    override fun fetchRecentArticles(): Single<List<Article>> {
        if (!networkManager.isNetworkConnection()) {
            return Single.error(NoNetworkConnectionException())
        }
        return remoteSource.getRecentArticles()
                .doOnSuccess { /* TODO: Insert into database + refresh last updated */ }
    }

    // fun getMoreRecentArticles()
    // fun getFullArticle(id)
}
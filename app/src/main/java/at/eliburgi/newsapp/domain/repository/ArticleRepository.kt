package at.eliburgi.newsapp.domain.repository

import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.model.TopArticleRequest
import io.reactivex.Single

/**
 * Created by Elias on 08.12.2017.
 */
interface ArticleRepository {
    /**
     * Returns a list of top news articles which may be directly from the API or a local
     * database or cache.
     */
    fun getTopArticles(request: TopArticleRequest): Single<List<Article>>

    /**
     * Returns a list of recent news articles which may be directly from the API or a local
     * database or cache.
     */
    fun getRecentArticles(): Single<List<Article>>

    /**
     * Fetch top articles directly from API.
     * In case of no internet connection or an API error, a respective error will be returned.
     */
    fun fetchTopArticles(request: TopArticleRequest): Single<List<Article>>

    /**
     * Fetch recent articles directly from API.
     * In case of no internet connection or an API error, a respective error will be returned.
     */
    fun fetchRecentArticles(): Single<List<Article>>

    // Based on previous request.
    //fun getMoreArticles()

    // fun getFullArticle(id): Single<FullArticle>
    //      -- Uses FullArticleDataSource.

    // fun getTimeLastRefreshed(): Long
}
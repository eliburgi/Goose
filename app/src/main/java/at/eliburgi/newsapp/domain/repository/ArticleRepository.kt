package at.eliburgi.newsapp.domain.repository

import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.model.TopArticleRequest
import io.reactivex.Single

/**
 * Created by Elias on 08.12.2017.
 */
interface ArticleRepository {

    fun getTopArticles(request: TopArticleRequest): Single<List<Article>>
    fun getRecentArticles(): Single<List<Article>>

    // fun getArticle(url): Single<Article>
    // fun getArticleDetails(url/article): Single<ArticleDetail>
}
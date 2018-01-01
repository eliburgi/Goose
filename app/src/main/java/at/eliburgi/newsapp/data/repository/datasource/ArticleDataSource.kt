package at.eliburgi.newsapp.data.repository.datasource

import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.model.TopArticleRequest
import io.reactivex.Single

/**
 * Created by Elias on 16.12.2017.
 */

interface ArticleDataSource {

    fun getTopArticles(request: TopArticleRequest): Single<List<Article>>
    fun getRecentArticles(): Single<List<Article>>

}
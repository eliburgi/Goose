package at.eliburgi.newsapp.data.repository.source

import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.model.TopArticleRequest
import io.reactivex.Single

/**
 * Created by Elias on 16.12.2017.
 */

interface ArticleSource {
    fun getTopArticles(request: TopArticleRequest): Single<List<Article>>   // remote
    fun getRecentArticles(): Single<List<Article>>                          // remote

    // fun getArticle(id)                                                   // local
    // fun getFullArticle(id)                                               // local
    // updateArticleBookmarked(id, true/false)                              // local
}
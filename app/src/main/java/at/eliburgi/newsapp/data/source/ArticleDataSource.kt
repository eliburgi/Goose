package at.eliburgi.newsapp.data.source

import at.eliburgi.newsapp.domain.model.Article
import io.reactivex.Single

/**
 * Created by Elias on 16.12.2017.
 */

interface ArticleDataSource {

    fun getTopArticles(): Single<List<Article>>
    fun getRecentArticles(): Single<List<Article>>

}
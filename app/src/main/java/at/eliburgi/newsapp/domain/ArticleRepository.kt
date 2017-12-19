package at.eliburgi.newsapp.domain

import at.eliburgi.newsapp.domain.model.Article
import io.reactivex.Single

/**
 * Created by Elias on 08.12.2017.
 */
interface ArticleRepository {

    fun getTopArticles(): Single<List<Article>>
    fun getRecentArticles(): Single<List<Article>>

}
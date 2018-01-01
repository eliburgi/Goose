package at.eliburgi.newsapp.data.repository

import at.eliburgi.newsapp.data.repository.datasource.ArticleDataSource
import at.eliburgi.newsapp.di.qualifier.Remote
import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.model.TopArticleRequest
import at.eliburgi.newsapp.domain.repository.ArticleRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Elias on 16.12.2017.
 */
@Singleton
class ArticleRepositoryImpl @Inject constructor(@Remote private val remoteSource: ArticleDataSource)
    : ArticleRepository {

    override fun getTopArticles(request: TopArticleRequest): Single<List<Article>> {
        return remoteSource.getTopArticles(request)
    }

    override fun getRecentArticles(): Single<List<Article>> {
        return remoteSource.getRecentArticles()
    }
}
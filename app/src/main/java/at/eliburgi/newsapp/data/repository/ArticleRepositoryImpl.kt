package at.eliburgi.newsapp.data.repository

import at.eliburgi.newsapp.data.source.ArticleDataSource
import at.eliburgi.newsapp.di.qualifier.Local
import at.eliburgi.newsapp.di.qualifier.Remote
import at.eliburgi.newsapp.domain.ArticleRepository
import at.eliburgi.newsapp.domain.model.Article
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Elias on 16.12.2017.
 */
@Singleton
class ArticleRepositoryImpl @Inject constructor(@Local private val localSource: ArticleDataSource,
                                                @Remote private val remoteSource: ArticleDataSource)
    : ArticleRepository {

    override fun getTopArticles(): Single<List<Article>> {
        return remoteSource.getTopArticles()
    }

    override fun getRecentArticles(): Single<List<Article>> {
        return remoteSource.getRecentArticles()
    }
}
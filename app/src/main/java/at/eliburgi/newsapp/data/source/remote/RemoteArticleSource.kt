package at.eliburgi.newsapp.data.source.remote

import at.eliburgi.newsapp.data.source.ArticleDataSource
import at.eliburgi.newsapp.data.source.Mapper
import at.eliburgi.newsapp.data.source.remote.api.NewsArticleApi
import at.eliburgi.newsapp.data.source.remote.api.RemoteApiErrorException
import at.eliburgi.newsapp.data.source.remote.model.ArticleResponse
import at.eliburgi.newsapp.di.qualifier.Remote
import at.eliburgi.newsapp.domain.model.Article
import io.reactivex.Single
import java.lang.IllegalStateException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Elias on 18.12.2017.
 */
@Singleton
@Remote
class RemoteArticleSource @Inject constructor(private val articleApi: NewsArticleApi,
                                              private val mapper: Mapper<ArticleResponse, Article>)
    : ArticleDataSource {

    override fun getTopArticles(): Single<List<Article>> {
        return articleApi.topArticles()
                .flatMap { response ->
                    when {
                        response.isSuccess() -> Single.just(response.articles!!)
                        response.isError() -> Single.error(RemoteApiErrorException(response.errorMessage))
                        else -> Single.error(IllegalStateException("Article Api response was neither successful nor was there an error!"))
                    }
                }
                .map(mapper::map)
    }

    // TODO
    override fun getRecentArticles(): Single<List<Article>> {
        return articleApi.topArticles()
                .flatMap { response ->
                    when {
                        response.isSuccess() -> Single.just(response.articles!!)
                        response.isError() -> Single.error(RemoteApiErrorException(response.errorMessage))
                        else -> Single.error(IllegalStateException("Article Api response was neither successful nor was there an error!"))
                    }
                }
                .map(mapper::map)
    }
}
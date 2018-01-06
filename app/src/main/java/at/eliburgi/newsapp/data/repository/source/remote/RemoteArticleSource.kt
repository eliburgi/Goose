package at.eliburgi.newsapp.data.repository.source.remote

import at.eliburgi.newsapp.data.repository.source.ArticleSource
import at.eliburgi.newsapp.data.mapper.Mapper
import at.eliburgi.newsapp.data.exception.RemoteApiErrorException
import at.eliburgi.newsapp.data.mapper.remote.TopArticleRequestMapper
import at.eliburgi.newsapp.data.model.remote.ArticleResponse
import at.eliburgi.newsapp.data.repository.source.remote.api.NewsArticleApi
import at.eliburgi.newsapp.di.qualifier.Remote
import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.model.TopArticleRequest
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
                                              private val articleMapper: Mapper<ArticleResponse, Article>,
                                              private val topRequestMapper: TopArticleRequestMapper)
    : ArticleSource {

    override fun getTopArticles(request: TopArticleRequest): Single<List<Article>> {
        val queryMap = topRequestMapper.map(request).build();
        return articleApi.topArticles(queryMap)
                .flatMap { response ->
                    when {
                        response.isSuccess() -> Single.just(response.articles!!)
                        response.isError() -> Single.error(RemoteApiErrorException(response.errorMessage))
                        else -> Single.error(IllegalStateException("Article Api response was neither successful nor was there an error!"))
                    }
                }
                .map(articleMapper::map)
    }

    override fun getRecentArticles(): Single<List<Article>> {
        return articleApi.recentArticles()
                .flatMap { response ->
                    when {
                        response.isSuccess() -> Single.just(response.articles!!)
                        response.isError() -> Single.error(RemoteApiErrorException(response.errorMessage))
                        else -> Single.error(IllegalStateException("Article Api response was neither successful nor was there an error!"))
                    }
                }
                .map(articleMapper::map)
    }
}
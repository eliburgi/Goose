package at.eliburgi.newsapp.di.module

import at.eliburgi.newsapp.data.mapper.ArticleIdMapper
import at.eliburgi.newsapp.data.mapper.Mapper
import at.eliburgi.newsapp.data.mapper.SimpleArticleIdMapper
import at.eliburgi.newsapp.data.mapper.remote.ArticleResponseMapper
import at.eliburgi.newsapp.data.mapper.remote.TopArticleRequestMapper
import at.eliburgi.newsapp.data.model.remote.ArticleResponse
import at.eliburgi.newsapp.data.model.remote.QueryMap
import at.eliburgi.newsapp.data.repository.ArticleRepositoryImpl
import at.eliburgi.newsapp.data.repository.source.ArticleSource
import at.eliburgi.newsapp.data.repository.source.remote.RemoteArticleSource
import at.eliburgi.newsapp.data.util.ContextNetworkManager
import at.eliburgi.newsapp.data.util.NetworkManager
import at.eliburgi.newsapp.di.qualifier.Remote
import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.model.TopArticleRequest
import at.eliburgi.newsapp.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Elias on 16.12.2017.
 */
@Module
class DataModule {
    @Provides
    @Singleton
    fun provideNetworkManager(manager: ContextNetworkManager): NetworkManager = manager

    @Provides
    @Singleton
    fun provideArticleIdMapper(mapper: SimpleArticleIdMapper): ArticleIdMapper = mapper

    @Provides
    @Singleton
    fun provideArticleResponseMapper(mapper: ArticleResponseMapper): Mapper<ArticleResponse, Article> = mapper

    @Provides
    @Singleton
    fun provideTopArticleRequestMapper(mapper: TopArticleRequestMapper)
            : Mapper<TopArticleRequest, QueryMap> = mapper

    @Singleton
    @Provides
    @Remote
    fun provideRemoteArticleSource(dataSource: RemoteArticleSource): ArticleSource = dataSource

    @Singleton
    @Provides
    fun provideArticleRepository(repository: ArticleRepositoryImpl): ArticleRepository = repository


}
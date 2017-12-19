package at.eliburgi.newsapp.di.module

import at.eliburgi.newsapp.data.dummy.DummyArticleDataSource
import at.eliburgi.newsapp.data.repository.ArticleRepositoryImpl
import at.eliburgi.newsapp.data.source.ArticleDataSource
import at.eliburgi.newsapp.data.source.Mapper
import at.eliburgi.newsapp.data.source.remote.RemoteArticleSource
import at.eliburgi.newsapp.data.source.remote.mapper.ArticleResponseMapper
import at.eliburgi.newsapp.data.source.remote.model.ArticleResponse
import at.eliburgi.newsapp.di.qualifier.Local
import at.eliburgi.newsapp.di.qualifier.Remote
import at.eliburgi.newsapp.domain.ArticleRepository
import at.eliburgi.newsapp.domain.model.Article
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Elias on 16.12.2017.
 */
@Module
class DataModule {

    @Singleton
    @Provides
    @Local
    fun provideLocalArticleSource(dataSource: DummyArticleDataSource): ArticleDataSource = dataSource

    @Singleton
    @Provides
    @Remote
    fun provideRemoteArticleSource(dataSource: RemoteArticleSource): ArticleDataSource = dataSource

    @Provides
    @Singleton
    fun provideArticleResponseMapper(mapper: ArticleResponseMapper): Mapper<ArticleResponse, Article> = mapper

    @Singleton
    @Provides
    fun provideArticleRepository(repository: ArticleRepositoryImpl): ArticleRepository = repository


}
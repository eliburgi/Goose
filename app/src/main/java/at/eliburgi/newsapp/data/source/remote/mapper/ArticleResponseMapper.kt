package at.eliburgi.newsapp.data.source.remote.mapper

import at.eliburgi.newsapp.data.source.Mapper
import at.eliburgi.newsapp.data.source.MapperUtils
import at.eliburgi.newsapp.data.source.remote.model.ArticleResponse
import at.eliburgi.newsapp.domain.model.Article
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Elias on 18.12.2017.
 */
@Singleton
class ArticleResponseMapper @Inject constructor() : Mapper<ArticleResponse, Article> {
    override fun map(from: ArticleResponse): Article {
        return Article(from.title,
                from.description,
                from.source.id,
                from.source.name,
                from.author,
                from.url,
                from.urlToImage,
                MapperUtils.convertUtcStringToMillis(from.publishedAt))
    }
}
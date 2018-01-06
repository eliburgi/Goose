package at.eliburgi.newsapp.data.mapper.remote

import at.eliburgi.newsapp.data.mapper.ArticleIdMapper
import at.eliburgi.newsapp.data.mapper.Mapper
import at.eliburgi.newsapp.data.mapper.MapperUtils
import at.eliburgi.newsapp.data.model.remote.ArticleResponse
import at.eliburgi.newsapp.domain.model.Article
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Elias on 18.12.2017.
 */
@Singleton
class ArticleResponseMapper @Inject constructor(val idMapper: ArticleIdMapper)
    : Mapper<ArticleResponse, Article> {
    override fun map(from: ArticleResponse): Article = Article(
            id = idMapper.map(from.url),
            url = from.url,
            title = from.title,
            sourceName = from.source.name,
            sourceId = from.source.id,
            description = from.description,
            author = from.author,
            urlToImage = from.urlToImage,
            publishedAt = MapperUtils.convertUtcStringToMillis(from.publishedAt))
}

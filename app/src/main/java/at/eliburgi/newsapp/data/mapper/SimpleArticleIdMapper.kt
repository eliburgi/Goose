package at.eliburgi.newsapp.data.mapper

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Maps an articles Url to Id and reverse such that an article´s Url is also its Id.
 **/
@Singleton
class SimpleArticleIdMapper @Inject constructor() : ArticleIdMapper {
    /**
     * Simply returns the given url, as the id is the same as the url.
     *
     * @param from the article´s Url
     * @return the article´s Id which was mapped from the Url, in this case simply the given Url
     */
    override fun map(from: ArticleUrl): ArticleId = from

    /**
     * Simply returns the given id, as the id is also the url.
     */
    override fun reverse(id: ArticleId): ArticleUrl = id
}
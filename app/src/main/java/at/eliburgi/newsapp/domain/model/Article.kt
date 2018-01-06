package at.eliburgi.newsapp.domain.model

import at.eliburgi.newsapp.domain.repository.BookmarkRepository


/**
 * Represents a news article.
 * NOTE: However, an [Article] does not contain any data like the full content text,
 * any media associated with that article, etc. This data is contained in the [FullArticle],
 * which contains all the data an [Article] contains plus the body text, etc.
 *
 * @param id an article´s unique ID, not empty
 * @param url URL to the article, not empty
 * @param title
 * @param sourceName name of the [NewsSource] that published this article
 * @param sourceId id of the [NewsSource] that published this article, may be null
 * @param description may be null
 * @param author may be null
 * @param urlToImage may be null
 * @param publishedAt UTC timestamp (millis) when the article was published, may be null
 */
open class Article(val id: String,
                   val url: String,
                   val title: String,
                   val sourceName: String,
                   val sourceId: String?,
                   val description: String?,
                   val author: String?,
                   val urlToImage: String?,
                   val publishedAt: Long?) {
    init {
        require(!id.isBlank(), { "Article ID may not be empty!" })
        require(!url.isBlank(), { "Article URL may not be empty!" })
    }

    fun hasDescription() = description != null
    fun hasSourceId() = sourceId != null
    fun hasAuthor() = author != null
    fun hasImageUrl() = urlToImage != null
    fun hasPublishedTime() = publishedAt != null

    // TODO: Add the following fields:
    // isTopArticle
    // isBookmarked
}
package at.eliburgi.newsapp.domain.model

/**
 * Represents a full news article, which in addition to all the data an [Article] contains,
 * also contains data like the full body text of the article, etc.
 *
 * @see [Article]
 */
class FullArticle(id: String,
                  url: String,
                  title: String,
                  sourceName: String,
                  sourceId: String?,
                  description: String?,
                  author: String?,
                  urlToImage: String?,
                  publishedAt: Long?)
    : Article(id, url, title, sourceName, sourceId, description, author, urlToImage, publishedAt) {

    companion object {
        @JvmStatic
        fun fromArticle(article: Article) = FullArticle(
                id = article.id,
                url = article.url,
                title = article.title,
                sourceName = article.sourceName,
                sourceId = article.sourceId,
                description = article.description,
                author = article.author,
                urlToImage = article.urlToImage,
                publishedAt = article.publishedAt)
    }

}
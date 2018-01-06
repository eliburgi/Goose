package at.eliburgi.newsapp.data.mapper

/**
 * Maps an article´s Url to its Id and reverse.
 */
interface ArticleIdMapper : Mapper<ArticleUrl, ArticleId> {
    fun reverse(id: ArticleId): ArticleUrl
}

typealias ArticleUrl = String
typealias ArticleId = String
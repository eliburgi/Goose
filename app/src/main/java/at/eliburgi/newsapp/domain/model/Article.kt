package at.eliburgi.newsapp.domain.model

/**
 * Created by Elias on 08.12.2017.
 */
data class Article(val title: String,
                   val description: String?,
                   val sourceId: String?,
                   val sourceName: String,
                   val author: String?,
                   val url: String,
                   val urlToImage: String?,
                   val publishedAt: Long)
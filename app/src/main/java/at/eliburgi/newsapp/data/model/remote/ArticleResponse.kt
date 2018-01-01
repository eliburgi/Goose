package at.eliburgi.newsapp.data.model.remote

import com.google.gson.annotations.SerializedName

/**
 * Created by Elias on 18.12.2017.
 */
class ArticleResponse(@SerializedName("source") val source: SourceResponse,
                      @SerializedName("author") val author: String?,
                      @SerializedName("title") val title: String,
                      @SerializedName("description") val description: String?,
                      @SerializedName("url") val url: String,
                      @SerializedName("urlToImage") val urlToImage: String?,
                      @SerializedName("publishedAt") val publishedAt: String?) {

    class SourceResponse(@SerializedName("id") val id: String?,
                         @SerializedName("name") val name: String)
}
package at.eliburgi.newsapp.data.source.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Elias on 18.12.2017.
 */
class TopArticleResponseWrapper(@SerializedName("status") private val status: String,
                                @SerializedName("message") val errorMessage: String?,
                                @SerializedName("articles") val articles: List<ArticleResponse>?) {

    fun isSuccess() = status == STATUS_OK
    fun isError() = status == STATUS_ERROR

    companion object {
        const val STATUS_OK = "ok"
        const val STATUS_ERROR = "error"
    }
}
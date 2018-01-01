package at.eliburgi.newsapp.data.model.remote

import com.google.gson.annotations.SerializedName

/**
 * Created by Elias on 18.12.2017.
 */
class TopArticleResponseWrapper(status: String,
                                errorMessage: String?,
                                @SerializedName("articles") val articles: List<ArticleResponse>?)
    : ApiResponseWrapper(status, errorMessage)
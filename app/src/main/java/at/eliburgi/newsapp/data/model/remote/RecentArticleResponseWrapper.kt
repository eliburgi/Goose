package at.eliburgi.newsapp.data.model.remote

import com.google.gson.annotations.SerializedName

/**
 * Created by Elias on 20.12.2017.
 */
class RecentArticleResponseWrapper(status: String,
                                   errorMessage: String?,
                                   @SerializedName("totalResults") val totalResults: Int,
                                   @SerializedName("articles") val articles: List<ArticleResponse>?)
    : ApiResponseWrapper(status, errorMessage)
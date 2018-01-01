package at.eliburgi.newsapp.data.repository.datasource.remote.api

import at.eliburgi.newsapp.data.model.remote.RecentArticleResponseWrapper
import at.eliburgi.newsapp.data.model.remote.TopArticleResponseWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Elias on 18.12.2017.
 */
interface NewsArticleApi {
    @GET(TOP_HEADLINES)
    fun topArticles(@QueryMap queryMap: Map<String, String>): Single<TopArticleResponseWrapper>

    @GET("$RECENT_HEADLINES?q=technology&sortBy=popularity")
    fun recentArticles(): Single<RecentArticleResponseWrapper>

    companion object {
        const val TOP_HEADLINES = "top-headlines"
        const val RECENT_HEADLINES = "everything"
    }
}
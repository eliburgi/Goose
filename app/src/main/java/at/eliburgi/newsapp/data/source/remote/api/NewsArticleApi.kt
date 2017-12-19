package at.eliburgi.newsapp.data.source.remote.api

import at.eliburgi.newsapp.data.source.remote.model.TopArticleResponseWrapper
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Elias on 18.12.2017.
 */
interface NewsArticleApi {

    @GET("top-headlines?q=bitcoin")
    fun topArticles(): Single<TopArticleResponseWrapper>

    // TODO
    @GET("top-headlines?q=bitcoin")
    fun recentArticles(): Single<TopArticleResponseWrapper>
}
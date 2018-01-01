package at.eliburgi.newsapp.di.module

import at.eliburgi.newsapp.BuildConfig
import at.eliburgi.newsapp.data.repository.datasource.remote.api.NewsArticleApi
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by Elias on 19.12.2017.
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    @Named("ApiBaseUrl")
    fun provideApiBaseUrl(): String = "https://newsapi.org/v2/"

    @Provides
    @Singleton
    @Named("ApiKey")
    fun provideApiKey(): String = BuildConfig.NewsApiKey

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    fun provideOkHttpClient(@Named("ApiKey") apiKey: String): OkHttpClient {
        // Add News Api Key automatically to every request.
        return OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val original = chain.request()
                    val originalHttpUrl = original.url()

                    val url = originalHttpUrl.newBuilder()
                            .addQueryParameter("apiKey", apiKey)
                            .build()

                    // Add api key to new request.
                    val request = original.newBuilder()
                            .url(url)
                            .build()

                    return@Interceptor chain.proceed(request)
                }).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("ApiBaseUrl") baseUrl: String,
                        client: OkHttpClient,
                        converterFactory: Converter.Factory,
                        callAdapterFactory: CallAdapter.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build()
    }

    @Provides
    @Singleton
    fun provideNewsArticleApi(retrofit: Retrofit): NewsArticleApi {
        return retrofit.create(NewsArticleApi::class.java)
    }

}
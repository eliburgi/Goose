package at.eliburgi.newsapp.data.repository

import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.assertEquals

import at.eliburgi.newsapp.data.repository.source.ArticleSource
import at.eliburgi.newsapp.data.util.NetworkManager
import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.model.TopArticleRequest
import io.reactivex.Single
import org.junit.Test

/**
 * Learning unit testing. Starting without a testing framework like Mockito to understand basics.
 */
@RunWith(JUnit4::class)
class ArticleRepositoryTest {

    private val dummyRemoteDataSource = object : ArticleSource {
        override fun getTopArticles(request: TopArticleRequest): Single<List<Article>> {
            return Single.just(remoteTopArticles)
        }

        override fun getRecentArticles(): Single<List<Article>> {
            return Single.just(remoteRecentArticles)
        }
    }

    @Before
    internal fun setup() {

    }

    @Test
    internal fun testGetTopArticlesWhenInternet() {
        // Given
        val dummyManager = object : NetworkManager {
            override fun isNetworkConnection(): Boolean {
                return true
            }
        }
        val repository = ArticleRepositoryImpl(dummyRemoteDataSource, dummyManager)
        val request = TopArticleRequest()

        // Make sure the repository returns articles from API if it has internet connection.
        repository.getTopArticles(request)
                .test()
                .assertOf { articles ->  assertEquals(articles, remoteTopArticles)}
    }

    internal fun testGetTopArticlesWhenNoInternet() {

    }

    internal fun testGetRecentArticlesWhenInternet() {

    }

    internal fun testGetRecentArticlesWhenNoInternet() {

    }

    internal fun testGetMoreArticlesWhenInternet() {

    }

    internal fun testGetMoreArticlesWhenNoInternet() {

    }

    companion object {
        private val remoteTopArticles = createDummyArticles(2, "top")
        private val remoteRecentArticles = createDummyArticles(3, "recent")

        private fun createDummyArticles(count: Int, tag: String) = (0 until count).map {
            Article(tag + "Id" + it,
                    tag + "topUrl" + it,
                    tag + "topTitle" + it,
                    tag + "topSrcName" + it,
                    tag + "topSrcId" + it,
                    tag + "topDescr" + it,
                    tag + "topAuth" + it,
                    tag + "topUrlImg" + it,
                    123L + it * 100)
        }
    }
}

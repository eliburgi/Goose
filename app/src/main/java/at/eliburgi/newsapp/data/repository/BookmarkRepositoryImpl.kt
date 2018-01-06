package at.eliburgi.newsapp.data.repository

import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.domain.repository.BookmarkRepository
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Elias on 05.01.2018.
 */
class BookmarkRepositoryImpl : BookmarkRepository {

    override fun addBookmarkToArticle(id: String): Completable {
        // 1. Preload full article content.
        //      -- Call LocalFullArticleDataSource.preloadFullArticle(id): Completable.
        // 2. Cache images.
        //      -- OnSuccessDoNext of 1. do: Tell some interface/utils to cache images from urlToImage.
        // 3. Update
        //      -- OnSuccessDoNext of 1. do: LocalBookmarkDataSource.bookmarkArticle(id, true/false)
        return Completable.complete()
    }

    override fun removeBookmarkFromArticle(id: String): Completable {
        // Uses BookmarkDataSource and FullArticleDataSource. -> LocalArticleDataSource implements FullArticleDataSource
        // localBookmarkDataSource.removeBookmark(id)
        return Completable.complete()
    }

    override fun getBookmarkedArticles(): Single<List<Article>> {
        // Get all articles that have the flag isBookmarked set to true from DB.
        return Single.just(emptyList())
    }
}
package at.eliburgi.newsapp.domain.repository

import at.eliburgi.newsapp.domain.model.Article
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Elias on 05.01.2018.
 */
interface BookmarkRepository {

    /**
     * Saves an [Article] for reading later.
     * This includes downloading the full article´s content, etc. as well as caching
     * the article´s images.
     *
     * @param id the ID of the article to be bookmarked
     * @return Whether or not the article was successfully bookmarked.
     *         If the article was already bookmarked true is returned
     */
    fun addBookmarkToArticle(id: String): Completable

    /**
     * Removes an [Article] from the list of bookmarked articles.
     *
     * @param id the ID of the article which bookmark should be removed
     */
    fun removeBookmarkFromArticle(id: String): Completable

    /**
     * Returns a list of all bookmarked [Article] stored.
     */
    fun getBookmarkedArticles(): Single<List<Article>>
}
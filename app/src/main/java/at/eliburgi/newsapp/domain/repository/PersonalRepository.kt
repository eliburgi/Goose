package at.eliburgi.newsapp.domain.repository

/**
 * Created by Elias on 08.12.2017.
 */
interface PersonalRepository {

    fun getSubscribedNewsSources()
    fun subscribeToNewsSource()
    fun unsubscribeFromNewsSource()
    fun getBookmarkedNewsArticles()
    fun bookmarkNewsArticles()

    // UserRepository
    // getPreferredLanguages()
    // addPreferredLanguages()
    // getPreferredCategories()
    // addPreferredCategories()
    // getPreferredUserInfo()
    // bookmarkArticle(article/url)
    // getBookmarkedArticles()

    // Article
    // add fields: isBookmarked: Boolean

    // User wants to read article later.
    // So he clicks on bookmark.
    // This adds a new job to the job queue.
    // When the job gets executed ->
    //      Try getting article details for this article.
    //      If that worked: Store ArticleDetails in DB.
    //      Otherwise

}
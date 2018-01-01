package at.eliburgi.newsapp.data.repository;

/**
 * Created by Elias on 30.12.2017.
 */

public class ArticleRepositoryTest {

    public void testNewsFeed() {
        // Get user info from UserRepository (getUserInfo - Languages, Categories, Sources)

        // NewsSourceRepository (get sources)
        // getSources
        // getUserSources()
        // subscribeToSource()
        // unsubFromSource

        // ArticleRepository
        // getTopArticles(request)
        // getRecentArticles(request)
        // OR encode refresh info in request (forceRefresh)?
        // fetchTopArticles(request)    // Bad because it breaks abstraction that repository clients don´t need to know where data comes from.
        // fetchRecentArticles(request) // same as above
        // bookmarkArticle(articleId)
        // getBookmarkedArticles()
        // getBookmarkedArticle(articleId)

        // UserRepository
        // addPreferredLanguages()
        // removePreferredLanguages()
        // getPreferredLanguages()
        // addPreferredCategories()
        // getPreferredCategories()
        // getUserInfo() -> returns all the above data in one object

        // Models
        // Language
        // Category
    }

    // Test paging
    // Test fetching
    // Test error
    // Test success

}

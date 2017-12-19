package at.eliburgi.newsapp.domain

/**
 * Created by Elias on 08.12.2017.
 */
interface PersonalRepository {

    fun getSubscribedNewsSources()
    fun subscribeToNewsSource()
    fun unsubscribeFromNewsSource()
    fun getBookmarkedNewsArticles()
    fun bookmarkNewsArticles()

}
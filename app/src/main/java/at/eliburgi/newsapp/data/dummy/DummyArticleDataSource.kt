package at.eliburgi.newsapp.data.dummy

import at.eliburgi.newsapp.data.source.ArticleDataSource
import at.eliburgi.newsapp.di.qualifier.Local
import at.eliburgi.newsapp.domain.model.Article
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Elias on 16.12.2017.
 */
@Singleton
@Local
class DummyArticleDataSource @Inject constructor() : ArticleDataSource {

    private val topArticles = listOf(
            Article("Sophia furzt so laut", "Laute Frze sind für Sophia B. nichts Neues. Vielmehr gehören sie bereits zum Alltag.", "bvt", "Bavarian FurzTenders", "Elias Burgstaller", "furz.com", "furzImg.com", 0),
            Article("Sophia furzt so laut", "Laute Frze sind für Sophia B. nichts Neues. Vielmehr gehören sie bereits zum Alltag.", "bvt", "Bavarian FurzTenders", "Elias Burgstaller", "furz.com", "furzImg.com", 0),
            Article("Sophia furzt so laut", "Laute Frze sind für Sophia B. nichts Neues. Vielmehr gehören sie bereits zum Alltag.", "bvt", "Bavarian FurzTenders", "Elias Burgstaller", "furz.com", "furzImg.com", 0),
            Article("Sophia furzt so laut", "Laute Frze sind für Sophia B. nichts Neues. Vielmehr gehören sie bereits zum Alltag.", "bvt", "Bavarian FurzTenders", "Elias Burgstaller", "furz.com", "furzImg.com", 0),
            Article("Sophia furzt so laut", "Laute Frze sind für Sophia B. nichts Neues. Vielmehr gehören sie bereits zum Alltag.", "bvt", "Bavarian FurzTenders", "Elias Burgstaller", "furz.com", "furzImg.com", 0),
            Article("Sophia furzt so laut", "Laute Frze sind für Sophia B. nichts Neues. Vielmehr gehören sie bereits zum Alltag.", "bvt", "Bavarian FurzTenders", "Elias Burgstaller", "furz.com", "furzImg.com", 0),
            Article("Sophia furzt so laut", "Laute Frze sind für Sophia B. nichts Neues. Vielmehr gehören sie bereits zum Alltag.", "bvt", "Bavarian FurzTenders", "Elias Burgstaller", "furz.com", "furzImg.com", 0),
            Article("Sophia furzt so laut", "Laute Frze sind für Sophia B. nichts Neues. Vielmehr gehören sie bereits zum Alltag.", "bvt", "Bavarian FurzTenders", "Elias Burgstaller", "furz.com", "furzImg.com", 0))


    override fun getTopArticles() = Single.just(topArticles)

    override fun getRecentArticles() = Single.just(topArticles)
}
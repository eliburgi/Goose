package at.eliburgi.newsapp.domain.repository

/**
 * Created by Elias on 08.12.2017.
 */
interface NewsSourceRepository {

    fun getNewsSources()
    // fun getNewsSources(request: NewsSourceRequest): Single<List<NewsSource>>
    // fun getNewsSourceDetails(sourceId: String/NewsSource): Single<NewsSourceDetail>
}
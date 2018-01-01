package at.eliburgi.newsapp.data.mapper.remote

import at.eliburgi.newsapp.data.mapper.Mapper
import at.eliburgi.newsapp.data.mapper.MapperUtils
import at.eliburgi.newsapp.data.model.remote.QueryMap
import at.eliburgi.newsapp.domain.model.TopArticleRequest
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Elias on 30.12.2017.
 */
@Singleton
class TopArticleRequestMapper @Inject constructor() : Mapper<TopArticleRequest, QueryMap> {

    override fun map(from: TopArticleRequest): QueryMap {
        val queryMap = QueryMap()

        // List of NewsSources from which articles are requested.
        val sources = from.getSourceIds()
        if (sources.isNotEmpty()) {
            queryMap.addParam(QUERY_SOURCES, MapperUtils.toCommaSeperatedString(sources))
        }

        // List of keywords that requested articles should contain.
        val keywords = from.getNonEmptyKeywords()
        if (keywords.isNotEmpty()) {
            queryMap.addParam(QUERY_KEYWORDS, MapperUtils.toCommaSeperatedString(keywords))
        }

        // Categories (e.g. sport, business, etc.) for which articles are requested.
        val categories = MapperUtils.mapCategoriesToApiIds(from.categories)
        if (categories.isNotEmpty()) {
            // TODO: NewsApi does not yet provide this functionality, such that there can be multiple
            // categories be requested in one request.
            // For now only the first category will be used.
            // TODO: Fix this code when NewsApi finally provides this feature.
            queryMap.addParam(QUERY_CATEGORIES, categories.first())
        }

        // Languages for which articles are requested.
        val languages = MapperUtils.mapLanguagesToApiIds(from.languages)
        if (languages.isNotEmpty()) {
            // TODO: Same as categories above.
            queryMap.addParam(QUERY_LANGUAGES, languages.first())
        }

        val countries = MapperUtils.mapCountriesToApiIds(from.countries)
        if (countries.isNotEmpty()) {
            // TODO: Same as categories above.
            queryMap.addParam(QUERY_COUNTRIES, countries.first())
        }

        return queryMap
    }

    companion object {
        const val QUERY_SOURCES = "sources"
        const val QUERY_KEYWORDS = "q"
        const val QUERY_CATEGORIES = "category"
        const val QUERY_LANGUAGES = "language"
        const val QUERY_COUNTRIES = "country"
    }
}
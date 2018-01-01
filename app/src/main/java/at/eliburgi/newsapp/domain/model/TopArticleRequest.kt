package at.eliburgi.newsapp.domain.model

import javax.xml.transform.Source

/**
 * Created by Elias on 30.12.2017.
 */
class TopArticleRequest(val sources: List<NewsSource> = emptyList(),
                        val keywords: List<String> = emptyList(),
                        val categories: List<Category> = emptyList(),
                        val languages: List<Language> = emptyList(),
                        val countries: List<Country> = emptyList()) {

    fun getSourceIds() = sources.map { source -> source.id }
            .filter { id -> id != null && id.isNotBlank() }
            .requireNoNulls()

    fun getNonEmptyKeywords() = keywords.filter { word -> word.isNotBlank() }
}
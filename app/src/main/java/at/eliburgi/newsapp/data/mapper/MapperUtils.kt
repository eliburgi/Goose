package at.eliburgi.newsapp.data.mapper

import android.util.Log
import at.eliburgi.newsapp.domain.model.Category
import at.eliburgi.newsapp.domain.model.Country
import at.eliburgi.newsapp.domain.model.Language
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Elias on 18.12.2017.
 */

internal object MapperUtils {
    private const val UTC_TIME_ZONE = "UTC"
    private const val ISO_8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    /**
     * Converts a given UTC date/time string in ISO_8601 format to a long timestamp in millis.
     * @param timeStamp must be in ISO_8601 format: e.g. "2017-12-18T13:22:32Z".
     * @return a long representing the UTC time in milliseconds. If the [timeStamp] is null or there was a parsing error, 0 is returned.
     */
    fun convertUtcStringToMillis(timeStamp: String?): Long {
        if (timeStamp == null) return 0

        return try {
            val formatter = SimpleDateFormat(ISO_8601_FORMAT)
            formatter.timeZone = TimeZone.getTimeZone(UTC_TIME_ZONE)
            formatter.parse(timeStamp).time
        } catch (e: ParseException) {
            Log.e("MapperUtils", "Error while parsing UTC timeStamp!")
            0
        }
    }

    fun toCommaSeperatedString(values: List<String>): String {
        val sb = StringBuilder()
        values.forEachIndexed { i, s ->
            sb.append(s)
            if (i != values.lastIndex) {
                sb.append(",")
            }
        }
        return sb.toString()
    }

    // Abstraction for category id. If domain-layer representation of category id changes
    // this is the only place where changes are necessary.
    fun mapCategoryToApiId(category: Category): String = category.id

    fun mapCategoriesToApiIds(categories: List<Category>) =
            categories.map { mapCategoryToApiId(it) }

    // Abstraction for language id. If domain-layer representation of language id changes
    // this is the only place where changes are necessary.
    fun mapLanguageToApiId(language: Language): String = language.id

    fun mapLanguagesToApiIds(languages: List<Language>) =
            languages.map { mapLanguageToApiId(it) }

    // Abstraction for country id. If domain-layer representation of country id changes
    // this is the only place where changes are necessary.
    fun mapCountryToApiId(country: Country): String = country.id

    fun mapCountriesToApiIds(countries: List<Country>) =
            countries.map { mapCountryToApiId(it) }
}
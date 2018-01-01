package at.eliburgi.newsapp.data.model.remote

/**
 * Created by Elias on 30.12.2017.
 */
class QueryMap {
    private val map = mutableMapOf<String, String>()

    fun addParam(key: String, value: String) {
        map.put(key, value)
    }

    fun build(): Map<String, String> = map
}
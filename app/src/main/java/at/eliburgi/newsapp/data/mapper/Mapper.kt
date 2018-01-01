package at.eliburgi.newsapp.data.mapper

/**
 * Created by Elias on 18.12.2017.
 */
interface Mapper<From, To> {

    fun map(from: From): To

    fun map(from: List<From>): List<To> {
        return from.map { map(it) }
    }
}
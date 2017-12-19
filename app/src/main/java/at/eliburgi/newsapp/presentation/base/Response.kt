package at.eliburgi.newsapp.presentation.base

/**
 * Created by Elias on 16.12.2017.
 */
class Response<T> private constructor(private val status: Int,
                                      val data: T? = null,
                                      val error: Throwable? = null) {
    fun isSuccess() = status == SUCCESS
    fun isError() = status == ERROR

    companion object {
        private const val SUCCESS = 0
        private const val ERROR = 1

        @JvmStatic
        fun <T> success(data: T) = Response(SUCCESS, data = data)

        @JvmStatic
        fun <T> error(error: Throwable) = Response<T>(ERROR, error = error)
    }
}
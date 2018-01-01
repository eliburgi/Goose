package at.eliburgi.newsapp.data.model.remote

import com.google.gson.annotations.SerializedName

/**
 * Created by Elias on 20.12.2017.
 */
abstract class ApiResponseWrapper(@SerializedName("status") private val status: String,
                                  @SerializedName("message") val errorMessage: String?) {
    fun isSuccess() = status == STATUS_OK
    fun isError() = status == STATUS_ERROR

    companion object {
        const val STATUS_OK = "ok"
        const val STATUS_ERROR = "error"
    }
}
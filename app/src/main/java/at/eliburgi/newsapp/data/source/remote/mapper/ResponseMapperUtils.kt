package at.eliburgi.newsapp.data.source.remote.mapper

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by Elias on 18.12.2017.
 */

object ResponseMapperUtils {
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
            Log.e("ResponseMapperUtils", "Error while parsing UTC timeStamp!")
            0
        }
    }

}
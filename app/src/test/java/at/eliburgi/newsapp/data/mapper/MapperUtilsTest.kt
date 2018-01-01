package at.eliburgi.newsapp.data.mapper

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by Elias on 18.12.2017.
 */
@RunWith(JUnit4::class)
class MapperUtilsTest {

    @Test
    fun testConvertStringToTimestamp() {
        val timeStamp = "2011-04-15T20:08:18Z"
        val convertedTimeStamp = MapperUtils.convertUtcStringToMillis(timeStamp)
        assertEquals(1302898098000, convertedTimeStamp)
    }

    @Test
    fun testConvertStringToTimestamp_InvalidFormat() {
        val timeStamp = "2011-04-15T08:18Z"
        val convertedTimeStamp = MapperUtils.convertUtcStringToMillis(timeStamp)
        assertEquals(0, convertedTimeStamp)
    }

}
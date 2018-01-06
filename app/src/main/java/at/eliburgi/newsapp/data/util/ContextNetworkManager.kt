package at.eliburgi.newsapp.data.util

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton
import android.net.ConnectivityManager


/**
 * Created by Elias on 05.01.2018.
 */
@Singleton
class ContextNetworkManager @Inject constructor(val context: Context) : NetworkManager {
    override fun isNetworkConnection(): Boolean {
        val manager = ConnectivityManager::class.java
                .cast(context.getSystemService(Context.CONNECTIVITY_SERVICE))
        val activeNetwork = manager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}
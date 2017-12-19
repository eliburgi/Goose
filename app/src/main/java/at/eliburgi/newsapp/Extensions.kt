package at.eliburgi.newsapp

import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by Elias on 16.12.2017.
 */

fun ViewGroup.inflateView(res: Int, attachToRoot: Boolean = true): View =
    LayoutInflater.from(context).inflate(res, this, attachToRoot)

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(context, message, duration).show()
}

fun Fragment.toast(@StringRes msgRes: Int, duration: Int = Toast.LENGTH_LONG) {
    toast(getString(msgRes), duration)
}

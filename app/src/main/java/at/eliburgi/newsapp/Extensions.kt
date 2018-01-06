package at.eliburgi.newsapp

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by Elias on 16.12.2017.
 */

// Common
infix fun <T> Boolean.then(value: T?)
        = if (this) value else null

inline fun <T> Boolean.then(function: () -> T, default: () -> T)
        = if (this) function() else default()

infix inline fun <reified T> Boolean.then(function: () -> T)
        = if (this) function() else null

infix inline fun <reified T, reified Type> Type?.then(callback: (Type) -> T)
        = if (this != null) callback(this) else null

// Android
fun ViewGroup.inflateView(res: Int, attachToRoot: Boolean = true): View =
    LayoutInflater.from(context).inflate(res, this, attachToRoot)

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(context, message, duration).show()
}

fun Fragment.toast(@StringRes msgRes: Int, duration: Int = Toast.LENGTH_LONG) {
    toast(getString(msgRes), duration)
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

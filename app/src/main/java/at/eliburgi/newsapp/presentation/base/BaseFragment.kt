package at.eliburgi.newsapp.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.eliburgi.newsapp.GooseApp

/**
 * Created by Elias on 16.12.2017.
 */
abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    fun appComponent() = (context!!.applicationContext as GooseApp).component

    protected abstract fun layoutId(): Int
    protected abstract fun inject()
}
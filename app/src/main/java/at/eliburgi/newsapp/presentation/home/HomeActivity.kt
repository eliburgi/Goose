package at.eliburgi.newsapp.presentation.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import at.eliburgi.newsapp.R
import at.eliburgi.newsapp.presentation.newsfeed.NewsFeedFragment
import at.eliburgi.newsapp.presentation.utils.StringUtils

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = StringUtils.EMPTY_STRING

        showNewsFeedFragment()
    }

    private fun showNewsFeedFragment() {
        val fragment = supportFragmentManager.findFragmentById(R.id.content)
        if(fragment == null || fragment !is NewsFeedFragment) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content, NewsFeedFragment())
                    .commit()
        }
    }

}

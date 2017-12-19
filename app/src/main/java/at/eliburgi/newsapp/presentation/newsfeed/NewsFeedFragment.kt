package at.eliburgi.newsapp.presentation.newsfeed


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import at.eliburgi.newsapp.R
import at.eliburgi.newsapp.di.component.DaggerViewComponent
import at.eliburgi.newsapp.di.module.ViewModule
import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.presentation.base.BaseFragment
import at.eliburgi.newsapp.toast
import kotlinx.android.synthetic.main.fragment_news_feed.*
import javax.inject.Inject

class NewsFeedFragment : BaseFragment() {

    @Inject
    lateinit var factory: NewsFeedViewModelFactory
    private lateinit var viewModel: NewsFeedViewModel
    private lateinit var feedAdapter: NewsFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, factory)[NewsFeedViewModel::class.java]
        startObservingViewModel()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        feedAdapter = NewsFeedAdapter()
        rv_articles_feed.adapter = feedAdapter
        rv_articles_feed.layoutManager = LinearLayoutManager(context)
        rv_articles_feed.setHasFixedSize(true)

        // Start loading news feed.
        viewModel.loadNewsFeed()
    }

    private fun updateNewsFeed(articles: List<Article>) {
        feedAdapter.addAll(articles)
    }

    private fun showErrorLoadingNewsFeed(error: Throwable) {
        toast("Error loading nes feed: ${error.message}")
        Log.e("NewsFeedFragment", "Error loading news feed: ${error.message}")
    }

    private fun startObservingViewModel() {
        // Observe news feed article stream.
        viewModel.newsFeed().observe(this, Observer { response ->
            response?.let {
                when {
                    response.isSuccess() -> updateNewsFeed(response.data!!)
                    response.isError() -> showErrorLoadingNewsFeed(response.error!!)
                }
            }
        })
    }

    override fun layoutId() = R.layout.fragment_news_feed

    override fun inject() {
        DaggerViewComponent.builder()
                .appComponent(appComponent())
                .viewModule(ViewModule())
                .build()
                .inject(this)
    }
}

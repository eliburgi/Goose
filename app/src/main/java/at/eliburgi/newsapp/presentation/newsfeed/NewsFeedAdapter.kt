package at.eliburgi.newsapp.presentation.newsfeed

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import at.eliburgi.newsapp.R
import at.eliburgi.newsapp.domain.model.Article
import at.eliburgi.newsapp.gone
import at.eliburgi.newsapp.inflateView
import at.eliburgi.newsapp.show
import com.squareup.picasso.Picasso

/**
 * Created by Elias on 16.12.2017.
 */
class NewsFeedAdapter(private val articles: MutableList<Article> = mutableListOf())
    : RecyclerView.Adapter<NewsFeedAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgHeader: ImageView = itemView.findViewById(R.id.img_article_header)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_article_title)
        private val tvSource: TextView = itemView.findViewById(R.id.tv_article_source)
        private val tvPublishedAt: TextView = itemView.findViewById(R.id.tv_article_published_time)
        private val tvDescription: TextView = itemView.findViewById(R.id.tv_article_description)

        fun bind(article: Article) {
            tvTitle.text = article.title
            tvSource.text = article.sourceName
            tvDescription.text = article.description

            if (article.publishedAt == 0L) {
                tvPublishedAt.gone()
            } else {
                tvPublishedAt.show()
                tvPublishedAt.text = "3 hours ago"  // TODO
            }

            if (article.urlToImage == null) {
                imgHeader.gone()
            } else {
                imgHeader.show()
                Picasso.with(itemView.context)
                        .load(article.urlToImage)
                        .fit()
                        .centerCrop()
                        .placeholder(R.drawable.placeholder_article_header)
                        .into(imgHeader)
            }
        }
    }

    fun addAll(articles: List<Article>) {
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflateView(R.layout.item_feed_article, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = articles.size
}
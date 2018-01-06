package at.eliburgi.newsapp.presentation.articlereader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import at.eliburgi.newsapp.R
import kotlinx.android.synthetic.main.activity_article_reader.*


class ArticleReaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_reader)

        val url = intent.extras.getString("url")
        webview_article.loadUrl(url)
        webview_article.webViewClient = WebViewClient()
        webview_article.webChromeClient = WebChromeClient()

        /*Single.fromCallable<Article?> {
            val config = Configuration(cacheDir.absolutePath)
            val extractor = ContentExtractor(config)

            val article = extractor.extractContent(url, false)
            if (article == null) {
                Log.e("ArticleReaderActivity", "Couldn't load the article, is your URL correct, is your Internet working?")
                return@fromCallable null
            }

            return@fromCallable article
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({article ->
                    val details = article?.cleanedArticleText
                    tv_article_title.text = article?.title
                    tv_article_text.text = article?.cleanedArticleText
                    tv_article_images.text = article?.topImage.toString()
                })*/
    }
}

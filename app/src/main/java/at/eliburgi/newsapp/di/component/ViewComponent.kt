package at.eliburgi.newsapp.di.component

import at.eliburgi.newsapp.di.module.ViewModule
import at.eliburgi.newsapp.di.scope.ViewScope
import at.eliburgi.newsapp.presentation.newsfeed.NewsFeedFragment
import dagger.Component

/**
 * Created by Elias on 16.12.2017.
 */
@ViewScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ViewModule::class))
interface ViewComponent {
    fun inject(fragment: NewsFeedFragment)
}
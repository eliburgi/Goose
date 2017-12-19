package at.eliburgi.newsapp

import android.app.Application
import at.eliburgi.newsapp.di.component.AppComponent
import at.eliburgi.newsapp.di.component.DaggerAppComponent
import at.eliburgi.newsapp.di.module.AppModule
import at.eliburgi.newsapp.di.module.DataModule

/**
 * Created by Elias on 16.12.2017.
 */
class GooseApp : Application() {

    lateinit var component: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        component = initDagger()
    }

    private fun initDagger() = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .dataModule(DataModule())
            .build()
}
package at.eliburgi.newsapp.domain.scheduler

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Elias on 16.12.2017.
 */
class SchedulerProvider : BaseScheduler {
    override fun io() = Schedulers.io()
    override fun computation() = Schedulers.computation()
    override fun trampoline() = Schedulers.trampoline()
    override fun ui() = AndroidSchedulers.mainThread()
}
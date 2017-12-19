package at.eliburgi.newsapp.domain.scheduler

import io.reactivex.Scheduler

/**
 * Created by Elias on 16.12.2017.
 */
interface BaseScheduler {
    fun io(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun ui(): Scheduler
}
package cam.sample.library.app

import android.content.Context
import android.databinding.BaseObservable
import rx.Subscription

/**
 * Created by panharithhuot on 9/25/17.
 */
abstract class BaseFragmentViewModel(protected val context: Context) : BaseObservable() {

    private val subscriptions = arrayListOf<Subscription>()

    open fun onCreated() {}

    open fun subscribe(): List<Subscription> = arrayListOf()

    open fun onStart() {
        subscriptions += subscribe()
    }

    open fun onDidFirstLayout() {}

    open fun onResume() {}

    open fun onPause() {}

    open fun onStop() {
        subscriptions.forEach { it.unsubscribe() }
        subscriptions.clear()
    }

    open fun onDestroy() {}

    protected fun addSubscription(subscription: Subscription) {
        subscriptions += subscription
    }

    protected fun addSubscriptions(subscription: List<Subscription>) {
        subscriptions += subscription
    }
}
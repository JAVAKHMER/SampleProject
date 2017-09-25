package cam.sample.library.app

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cam.sample.library.util.waitForLayout
import rx.Subscription

/**
 * Created by panharithhuot on 9/25/17.
 */
abstract class BaseFragment<B : ViewDataBinding, out VM : BaseFragmentViewModel> : Fragment() {

    protected abstract val layoutId: Int @LayoutRes get

    protected abstract val variable: Int @IdRes get

    protected abstract val viewModel: VM

    protected open val variables @IdRes get() = hashMapOf<Int, Any>()

    private var binding: B? = null

    private val subscriptions = arrayListOf<Subscription>()

    open fun subscribe(): List<Subscription> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding?.let {
            it.setVariable(variable, viewModel)
            variables.keys.forEach { key ->
                it.setVariable(key, variables[key])
            }
            it.executePendingBindings()
            it.root?.waitForLayout {
                viewModel.onDidFirstLayout()
            }
        }
        return binding?.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onCreated()
    }

    override fun onStart() {
        subscriptions += subscribe()
        super.onStart()
        viewModel.onStart()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onStop() {
        subscriptions.forEach { it.unsubscribe() }
        subscriptions.clear()
        super.onStop()
        viewModel.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    protected fun addSubscription(subscription: Subscription) {
        subscriptions += subscription
    }

    protected fun addSubscriptions(subscription: List<Subscription>) {
        subscriptions += subscription
    }

    open fun onBackPressed() = false
}
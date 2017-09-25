package panharith.sample.cam.sampleproject.view.splash

import android.content.Context
import panharith.sample.cam.sampleproject.common.base.AppBaseFragmentViewModel
import rx.Subscription

/**
 * View model for MainFragment
 */
class SplashFragmentVM(context: Context) : AppBaseFragmentViewModel(context) {

    override fun subscribe(): List<Subscription> {
        return arrayListOf(
        )
    }

    override fun onDidFirstLayout() {
        super.onDidFirstLayout()
        showLoading(0.1f)
    }
}
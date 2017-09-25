package panharith.sample.cam.sampleproject.view.first_fragment

import android.content.Context
import panharith.sample.cam.sampleproject.common.base.AppBaseFragmentViewModel
import rx.Subscription

/**
 * Created by panharithhuot on 9/25/17.
 */
class FirstFragmentVM(context: Context) : AppBaseFragmentViewModel(context) {

    override fun subscribe(): List<Subscription> {
        return arrayListOf(
        )
    }

    override fun onDidFirstLayout() {
        super.onDidFirstLayout()
        showLoading(0.1f)
    }
}
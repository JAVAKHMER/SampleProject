package panharith.sample.cam.sampleproject.common.base

import android.databinding.ViewDataBinding
import cam.sample.library.app.BaseFragment

/**
 * Created by panharithhuot on 9/25/17.
 */
abstract class AppBaseFragment<B : ViewDataBinding, out VM : AppBaseFragmentViewModel> : BaseFragment<B, VM>() {

    override fun onStart() {
        super.onStart()
    }
}
package panharith.sample.cam.sampleproject.view.splash

import panharith.sample.cam.sampleproject.BR
import panharith.sample.cam.sampleproject.R
import panharith.sample.cam.sampleproject.common.base.AppBaseFragment
import panharith.sample.cam.sampleproject.databinding.FragmentMainBinding

/**
 * メインFragment
 */
class SplashFragment : AppBaseFragment<FragmentMainBinding, SplashFragmentVM>() {

    override val layoutId = R.layout.fragment_splash

    override val variable = BR.vm

    override val viewModel by lazy { SplashFragmentVM(context) }
}
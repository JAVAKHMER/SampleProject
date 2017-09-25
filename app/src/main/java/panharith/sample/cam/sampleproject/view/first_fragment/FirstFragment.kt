package panharith.sample.cam.sampleproject.view.first_fragment

import panharith.sample.cam.sampleproject.BR
import panharith.sample.cam.sampleproject.R
import panharith.sample.cam.sampleproject.common.base.AppBaseFragment
import panharith.sample.cam.sampleproject.databinding.FragmentMainBinding

/**
 * Created by panharithhuot on 9/25/17.
 */
class FirstFragment : AppBaseFragment<FragmentMainBinding, FirstFragmentVM>() {

    override val layoutId = R.layout.fragment_first

    override val variable = BR.vm

    override val viewModel by lazy { FirstFragmentVM(context) }
}
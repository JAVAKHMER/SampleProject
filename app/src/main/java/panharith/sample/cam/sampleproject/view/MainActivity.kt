package panharith.sample.cam.sampleproject.view

import panharith.sample.cam.sampleproject.R
import panharith.sample.cam.sampleproject.common.base.AppBaseActivity
import panharith.sample.cam.sampleproject.common.base.AppBaseFragment
import panharith.sample.cam.sampleproject.view.first_fragment.FirstFragment

class MainActivity : AppBaseActivity() {

    override val layoutId get() = R.layout.activity_main

    override val firstFragment: AppBaseFragment<*, *> by lazy {
        FirstFragment()
    }
}

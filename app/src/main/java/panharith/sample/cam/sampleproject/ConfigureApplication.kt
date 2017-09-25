package panharith.sample.cam.sampleproject

import cam.sample.library.app.BaseApplication
import net.danlew.android.joda.JodaTimeAndroid
import panharith.sample.cam.sampleproject.common.base.AppBaseFragment
import panharith.sample.cam.sampleproject.common.base.AppBaseFragmentViewModel
import panharith.sample.cam.sampleproject.view.first_fragment.FirstFragment
import panharith.sample.cam.sampleproject.view.first_fragment.FirstFragmentVM
import panharith.sample.cam.sampleproject.view.splash.SplashFragment
import panharith.sample.cam.sampleproject.view.splash.SplashFragmentVM
import java.io.Serializable
import kotlin.reflect.KClass

/**
 * Created by panharithhuot on 9/25/17.
 */
class ConfigureApplication : BaseApplication(){
    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(applicationContext)
    }

    companion object {
        private val fragmentVMMap = hashMapOf(FirstFragmentVM::class to FirstFragment::class, SplashFragmentVM::class to SplashFragment::class)

        fun <T> createFragment(vmClass: KClass<out T>, args: Serializable? = null): AppBaseFragment<*, *> where T : AppBaseFragmentViewModel =
                fragmentVMMap[vmClass]!!.java.newInstance().apply {  }
    }



}
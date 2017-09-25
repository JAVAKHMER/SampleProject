package panharith.sample.cam.sampleproject.common.base

import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import panharith.sample.cam.sampleproject.R

/**
 * Created by panharithhuot on 9/25/17.
 */
abstract class AppBaseActivity : AppCompatActivity() {

    protected abstract val layoutId: Int @LayoutRes get

    protected open val firstFragment: AppBaseFragment<*, *>? = null

    private val currentFragment: AppBaseFragment<*, *>?
        get() {
            if (supportFragmentManager.backStackEntryCount == 0)
                return rootFragment
            val name = supportFragmentManager.getBackStackEntryAt(supportFragmentManager.backStackEntryCount - 1).name
            return supportFragmentManager.findFragmentByTag(name) as? AppBaseFragment<*, *>
        }

    private var rootFragment: AppBaseFragment<*, *>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        rootFragment = firstFragment
        firstFragment?.let {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayoutFragment, it)
                    .commit()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed()?.let {
            if (it)
                return
        }
        super.onBackPressed()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
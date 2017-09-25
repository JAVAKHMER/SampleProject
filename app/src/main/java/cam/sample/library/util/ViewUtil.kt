package cam.sample.library.util

import android.view.View
import android.view.ViewTreeObserver

/**
 * Created by panharithhuot on 9/25/17.
 */

fun View.waitForLayout(f: () -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            f()
        }
    })
}
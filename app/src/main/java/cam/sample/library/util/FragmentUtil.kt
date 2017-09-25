@file:Suppress("unused")

package cam.sample.library.util

import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by panharithhuot on 9/25/17.
 */
var Fragment.fragmentArgs
    get() = arguments?.getSerializable("FragmentArgs")
    set(value) {
        arguments = arguments ?: Bundle()
        arguments.putSerializable("FragmentArgs", value)
    }
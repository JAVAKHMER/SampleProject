package panharith.sample.cam.sampleproject.common.base

import android.content.Context
import cam.sample.library.app.BaseFragmentViewModel
import rx.Observable
import rx.subjects.PublishSubject

/**
 * Created by panharithhuot on 9/25/17.
 */
abstract class AppBaseFragmentViewModel(context: Context) : BaseFragmentViewModel(context) {

    // region for View

    private val showLoadingSubject = PublishSubject.create<Float>()
    private val hideLoadingSubject = PublishSubject.create<Any>()

    val showLoading: Observable<Float> = showLoadingSubject.asObservable()
    val hideLoading: Observable<Any> = hideLoadingSubject.asObservable()

    /**
     * ローディング表示
     *
     * @param alpha Alpha
     */
    fun showLoading(alpha: Float? = null) {
        showLoadingSubject.onNext(alpha)
    }

    /**
     * ローディング非表示
     */
    fun hideLoading() {
        hideLoadingSubject.onNext(null)
    }


}

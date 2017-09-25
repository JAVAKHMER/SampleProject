package cam.sample.library.app

import android.app.Application
import android.net.http.HttpResponseCache
import java.io.File

/**
 * Created by panharithhuot on 9/25/17.
 */
abstract class BaseApplication : Application() {
    protected open val httpCacheSize = 100 * 1024 * 1024L

    override fun onCreate() {
        super.onCreate()
        HttpResponseCache.install(File(applicationContext.cacheDir, "http_cache"), httpCacheSize)
    }
}
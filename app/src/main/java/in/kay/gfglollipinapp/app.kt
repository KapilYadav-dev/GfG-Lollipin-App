package `in`.kay.gfglollipinapp

import android.app.Application
import com.github.omadahealth.lollipin.lib.managers.LockManager

class app: Application() {
    override fun onCreate() {
        super.onCreate()
        // Here we are enabling our custom Pin code activity
        LockManager.getInstance().enableAppLock(this,PinCodeKotlin::class.java)
        // We are setting custom logo for our Pin code activity
        LockManager.getInstance().appLock.logoId=R.drawable.ic_gfg
    }
}
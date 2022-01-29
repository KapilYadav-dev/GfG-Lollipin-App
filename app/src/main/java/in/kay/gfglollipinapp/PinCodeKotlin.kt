package `in`.kay.gfglollipinapp

import android.widget.Toast
import com.github.omadahealth.lollipin.lib.managers.AppLockActivity

class PinCodeKotlin : AppLockActivity() {


    // For Implementing forgot pin logic
    override fun showForgotDialog() {
        Toast.makeText(this,"Implement your forgot password logic here.",Toast.LENGTH_LONG).show()
    }

    // For handling pin failure  events
    override fun onPinFailure(attempts: Int) {
        Toast.makeText(this,"Pin entered is Incorrect and attempts done are $attempts",Toast.LENGTH_LONG).show()
    }

    // For handling pin success events
    override fun onPinSuccess(attempts: Int) {
        Toast.makeText(this,"Correct Pin",Toast.LENGTH_LONG).show()
    }

    // For overriding default length option
    // We can override the size of Pin required as we want
    override fun getPinLength(): Int {
        return 4
    }
}
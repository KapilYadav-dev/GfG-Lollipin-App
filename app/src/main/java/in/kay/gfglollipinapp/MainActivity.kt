package `in`.kay.gfglollipinapp

import `in`.kay.gfglollipinapp.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.omadahealth.lollipin.lib.managers.AppLock
import com.github.omadahealth.lollipin.lib.managers.LockManager


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var locker = LockManager.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  locker.appLock.logoId=R.drawable.ic_gfg
        // Used to enable our locker first time
        binding.btnEnable.setOnClickListener {
            val intent = Intent(this@MainActivity, PinCodeKotlin::class.java)
            intent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK)
            startActivityForResult(intent, 101)
        }
        binding.btnChangePin.setOnClickListener {
            val intent = Intent(this@MainActivity, PinCodeKotlin::class.java)

            //We are checking that is our passcode is already set or not
            // In simple terms if user is new and he didn't set the passcode then we will send it to choose new passcode
            if (locker.isAppLockEnabled && locker.appLock.isPasscodeSet) {
                intent.putExtra(AppLock.EXTRA_TYPE, AppLock.CHANGE_PIN)
                startActivity(intent)
            } else {
                intent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK)
                startActivityForResult(intent, 101)
            }
        }
        binding.btnGoToLocked.setOnClickListener {
            val intent = Intent(this@MainActivity, LockedActivity::class.java)
            startActivity(intent)
        }
        binding.btnDisable.setOnClickListener {
            locker.disableAppLock()
            Toast.makeText(this,"Disabled pin code successfully",Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            101 -> {
                Toast.makeText(this, "PinCode enabled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
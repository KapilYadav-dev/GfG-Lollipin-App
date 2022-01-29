package `in`.kay.gfglollipinapp

import `in`.kay.gfglollipinapp.databinding.ActivityLockedBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.omadahealth.lollipin.lib.PinActivity
import com.github.omadahealth.lollipin.lib.PinCompatActivity

class LockedActivity :  PinCompatActivity() {
    private lateinit var binding: ActivityLockedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLockedBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
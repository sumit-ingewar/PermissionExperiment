package sumit.com.zagtraderexperiment

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test.setOnClickListener {
            testPermission()
        }
    }

    private fun testPermission() {
        GlobalScope.launch(Dispatchers.Main, CoroutineStart.DEFAULT) {

            try {
                val result = askPermission(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                Log.e("isAccepted","isAccepted")
            } catch (e: PermissionException) {
                if (e.hasDenied()) {

                    Log.e("Denied","Denied")

                }

                if (e.hasForeverDenied()) {
                    Log.e("hasForeverDenied","hasForeverDenied")
                }
            }
        }
    }
}

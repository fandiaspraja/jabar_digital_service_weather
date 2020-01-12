package sample.base.app.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import sample.base.app.R
import sample.base.app.ui.form.FormActivity
import sample.base.app.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {


    private val SPLASH_TIME_OUT:Long=3000 // 3 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, FormActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}

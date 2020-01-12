package sample.base.app.ui.form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form.*
import sample.base.app.R
import sample.base.app.ui.main.MainActivity

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        btn_checkweather.setOnClickListener {
            checkFormInput()
        }
    }

    fun checkFormInput(){
        if (et_name.text.isNullOrEmpty() && et_postalcode.text.isNullOrEmpty()){
            Toast.makeText(applicationContext, "Please insert name and postal code", Toast.LENGTH_LONG).show()
        }else if (et_name.text.isNullOrEmpty()){
            Toast.makeText(applicationContext, "Please insert name", Toast.LENGTH_LONG).show()
        }else if (et_postalcode.text.isNullOrEmpty()){
            Toast.makeText(applicationContext, "Please insert postal code", Toast.LENGTH_LONG).show()
        }else{

            val name: String = et_name.text.toString() // or just your string
            val postalCode: String = et_postalcode.text.toString() // or just your string
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("postalcode", postalCode)
            startActivity(intent)
        }
    }
}

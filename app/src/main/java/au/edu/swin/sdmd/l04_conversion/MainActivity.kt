package au.edu.swin.sdmd.l04_conversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            val tvFahrenheit = findViewById<TextView>(R.id.fahrenheit)
            tvFahrenheit.text = it.getString("fahrenheit").toString()
        }

        val button = findViewById<Button>(R.id.converter)
        button.setOnClickListener {
            val etCelsius = findViewById<EditText>(R.id.celsuis)
            val celsius = etCelsius.text.toString().toFloat()
            val fahrenheit = (celsius * 9/5) + 32
            val tvFahrenheit = findViewById<TextView>(R.id.fahrenheit)
            tvFahrenheit.text = fahrenheit.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val tvFahrenheit = findViewById<TextView>(R.id.fahrenheit)

        outState.putString("fahrenheit", tvFahrenheit.text.toString())
        super.onSaveInstanceState(outState)
    }
}
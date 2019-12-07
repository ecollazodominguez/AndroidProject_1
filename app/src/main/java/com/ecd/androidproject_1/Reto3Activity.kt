package com.ecd.androidproject_1

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_reto3.*
import org.jetbrains.anko.toast

class Reto3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto3)
        toast("Un poco de matemáticas...")
        num1.setEnabled(false)
        num2.setEnabled(false)
        num3.setEnabled(false)
        okbutton.setOnClickListener{( calcular(it))}
    }

    //método para calcular y comprobar que la respuesta es la correcta
    private fun calcular(v: View){
        var num1 = Integer.parseInt(num1.text.toString())
        var num2 = Integer.parseInt(num2.text.toString())
        var num3 = Integer.parseInt(num3.text.toString())

        var calculo = num1 + num2 * num3
            var respuesta = Integer.parseInt(respuestacalc.text.toString())

            if (calculo == respuesta) {
                var resp = true
                val intent = Intent()
                intent.putExtra("resp", resp)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                finish()
            }

        }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
    }


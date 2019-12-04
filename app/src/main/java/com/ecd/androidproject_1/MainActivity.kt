package com.ecd.androidproject_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*





const val RETO1_REQUEST = 1
const val RETO2_REQUEST = 2
const val RETO3_REQUEST = 3
const val RETO4_REQUEST = 4

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Llamada a botones para iniciar activities.
        reto1.setOnClickListener { abrirRetos(it,1) }
        reto2.setOnClickListener { abrirRetos(it,2) }
        reto3.setOnClickListener { abrirRetos(it,3) }
        reto4.setOnClickListener { abrirRetos(it,4) }
    }

    //Método para iniciar activites.
    fun abrirRetos(v: View, num: Int) {

        when (num) {
            1 -> {val intent = Intent(this, Reto1Activity::class.java)
            startActivityForResult(intent, RETO1_REQUEST)}

            2->  {val intent = Intent(this, Reto2Activity::class.java)
                startActivityForResult(intent, RETO2_REQUEST)}

            3->  {val intent = Intent(this, Reto3Activity::class.java)
                startActivityForResult(intent, RETO3_REQUEST)}

            4->  {val intent = Intent(this, Reto3Activity::class.java)
                startActivityForResult(intent, RETO4_REQUEST)}
        }
    }

    //Método para manetener la app en pantalla completa para ocultar los botones de barra.
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

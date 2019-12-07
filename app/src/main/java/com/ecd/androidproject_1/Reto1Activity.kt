package com.ecd.androidproject_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_reto1.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.toast

class Reto1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto1)
        toast("¡¡Responde correctamente para ganar!!")
        r1button.setOnClickListener { (respuesta(it,1)) }
        r2button.setOnClickListener { (respuesta(it,2)) }
        r3button.setOnClickListener { (respuesta(it,3)) }
        helpbutton.setOnClickListener { (ayuda(it)) }
    }

    //Método para seleccionar la respuesta correcta, recibe un int que será la posición de la respuesta, si no es 2, es falso, sino, true
    private fun respuesta(v: View, r:Int){
        if (r == 2){
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        finish()

    }

    // Método de ayuda que te abre el navegador para buscar la solución
    private fun ayuda (v:View){
        browse("https://es.wikipedia.org/wiki/Viuda_Negra_(personaje)")
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

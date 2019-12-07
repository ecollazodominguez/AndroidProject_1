package com.ecd.androidproject_1

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_reto4.*
import org.jetbrains.anko.toast

class Reto4Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto4)
        imagesonido.setOnClickListener{(sonido(it))}
        okbutton.setOnClickListener{(comprobacion(it))}
        toast("Creo que era el silbido de un pájaro de cierta película... ")


    }

    //Método para reproducir sonido más de una vez
    private fun sonido(v: View){
        val mp = MediaPlayer.create(this, R.raw.sinsajo) //Cogemos el audio de res/raw
        mp.start()
    }

    //Comprobamos que la respuesta sea correcta
    private fun comprobacion(v:View){
        if (respuestatexto.text.toString().equals("sinsajo") || (respuestatexto.text.toString().equals("Sinsajo"))){
            val intent = Intent()
            setResult(Activity.RESULT_OK, intent)
            finish()

        }else{
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

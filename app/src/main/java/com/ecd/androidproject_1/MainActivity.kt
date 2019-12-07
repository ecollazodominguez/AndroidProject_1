package com.ecd.androidproject_1

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast


const val RETO1_REQUEST = 1
const val RETO2_REQUEST = 2
const val RETO3_REQUEST = 3
const val RETO4_REQUEST = 4

class MainActivity : AppCompatActivity() {

    var retoscompletados = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Llamada a botones para iniciar activities.
        reto1.setOnClickListener { abrirRetos(it, 1) }
        reto2.setOnClickListener { abrirRetos(it, 2) }
        reto3.setOnClickListener { abrirRetos(it, 3) }
        reto4.setOnClickListener { abrirRetos(it, 4) }

    }

    //Método para iniciar activites.
    fun abrirRetos(v: View, num: Int) {

        when (num) {
            1 -> {
                val intent = Intent(this, Reto1Activity::class.java)
                startActivityForResult(intent, RETO1_REQUEST)
            }

            2 -> {
                val intent = Intent(this, Reto2Activity::class.java)
                startActivityForResult(intent, RETO2_REQUEST)
            }

            3 -> {
                val intent = Intent(this, Reto3Activity::class.java)
                startActivityForResult(intent, RETO3_REQUEST)
            }

            4 -> {
                val intent = Intent(this, Reto4Activity::class.java)
                startActivityForResult(intent, RETO4_REQUEST)
            }

        }
    }

        private fun completo(){
                startActivity(intentFor<WinActivity>().singleTop())
        }

        //Recogemos los resultados
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == RETO1_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {

                    toast("¡Enhorabuena has acertado!")
                    reto1.setBackgroundResource(R.drawable.reto1grey) //cambiamos el icono a gris
                    reto1.setEnabled(false) //desactivamos el boton
                    retoscompletados += 1
                    //si ganas todos los retos
                    if (retoscompletados == 4) {
                        completo()

                    }

                } else {
                    toast("Has fallado... ¡Vuelve a intentarlo!")
                }


            }

            if (requestCode == RETO2_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {

                    val imageBitmap = data?.extras?.get("foto") as Bitmap
                    var pixel1 = imageBitmap.getPixel(0, 0)
                    var redValue = Color.red(pixel1)
                    var blueValue = Color.blue(pixel1)
                    var greenValue = Color.green(pixel1)

                    if (greenValue > blueValue && greenValue > redValue) {
                        var pixel2 = imageBitmap.getPixel(5, 5)
                        var redValue = Color.red(pixel2)
                        var blueValue = Color.blue(pixel2)
                        var greenValue = Color.green(pixel2)
                        if (greenValue > blueValue && greenValue > redValue) {
                            var pixel3 = imageBitmap.getPixel(15, 15)
                            var redValue = Color.red(pixel3)
                            var blueValue = Color.blue(pixel3)
                            var greenValue = Color.green(pixel3)
                            if (greenValue > blueValue && greenValue > redValue) {
                                toast("¡¡Bien hecho!!")
                                reto2.setBackgroundResource(R.drawable.reto2grey) //cambiamos el icono a gris
                                reto2.setEnabled(false)
                                retoscompletados += 1
                                //si ganas todos los retos
                                if (retoscompletados == 4) {
                                    completo()

                                }
                            } else {
                                toast("Has fallado... ¡Vuelve a intentarlo!")
                            }
                        } else {
                            toast("Has fallado... ¡Vuelve a intentarlo!")
                        }
                    } else {
                        toast("Has fallado... ¡Vuelve a intentarlo!")
                    }
                }
            }

            if (requestCode == RETO3_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {
                    toast("¡Enhorabuena has acertado!")
                    reto3.setBackgroundResource(R.drawable.reto3grey) //cambiamos el icono a gris
                    reto3.setEnabled(false) //desactivamos el boton
                    retoscompletados += 1
                    //si ganas todos los retos
                    if (retoscompletados == 4) {
                        completo()

                    }

                } else {
                    toast("Has fallado... ¡Vuelve a intentarlo!")
                }
            }

            if (requestCode == RETO4_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {
                    toast("¡Enhorabuena has acertado!")
                    reto4.setBackgroundResource(R.drawable.reto4grey) //cambiamos el icono a gris
                    reto4.setEnabled(false) //desactivamos el boton
                    retoscompletados += 1
                    //si ganas todos los retos
                    if (retoscompletados == 4) {
                        completo()

                    }

                } else {
                    toast("Has fallado... ¡Vuelve a intentarlo!")
                }
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
package com.ecd.androidproject_1

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_reto1.*
import kotlinx.android.synthetic.main.activity_reto2.*
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.toast

const val CAMERA_REQUEST = 5

class Reto2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto2)
        toast("¿Podrás conseguirlo?")
        imagebutton.setOnClickListener { (camera(it)) }
        okbutton.setOnClickListener { volver(it) }
    }

    //Método que pide permisos y abre la cámara con un result para guardar la foto
    private fun camera(v:View){
        //Chequea si tiene permisos
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {

            //Si no tiene y no los has rechazado por siempre, pasará por TRUE, incluso aunque denieges 1 vez
            // si rechazaste por siempre pasa por FALSE y no puede pedir permisos NUNCA.
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CAMERA
                )
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    1
                )
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, CAMERA_REQUEST)
                cameraIntent.putExtra("foto",cameraIntent)
                setResult(Activity.RESULT_OK, cameraIntent)
            } else {
                toast("RECHAZADO POR SIEMPRE")

            }
        } else {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST)
            cameraIntent.putExtra("foto",cameraIntent)
            setResult(Activity.RESULT_OK, cameraIntent)
        }
    }

    //método para volver a la activity principal finalizando esta
    private fun volver(v:View){
        finish()
    }
    // recogemos el resultado mostrando la foto en el botón y devolvemos el resultado al main
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {


            val imageBitmap = data?.extras?.get("data") as Bitmap
            imagebutton.setBackgroundResource(0)
            imagebutton.setImageBitmap(imageBitmap)
            val intent = Intent()
            intent.putExtra("foto", imageBitmap)
            setResult(Activity.RESULT_OK, intent)

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

package com.applendar.applendar.Perfil

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.applendar.applendar.R
import kotlinx.android.synthetic.main.activity_perfil_user.*


class PerfilUser : AppCompatActivity() {
    private val Respuesta_Galeria = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_user)

        OpenGalery_Click()
    }

    private fun OpenGalery_Click(){
        Btn_edit_perfil.setOnClickListener {
            //verificacion de API
            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
                //consulta de permiso
                if(checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    val permisoDeArchivo = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permisoDeArchivo,Respuesta_Galeria)
                }else{
                    ShowGalery()
                }

            }else{
                ShowGalery()
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Respuesta_Galeria -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ShowGalery()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "No se pudo acceder a la Galeria",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    private fun ShowGalery(){
        val intentGalery: Intent = Intent(Intent.ACTION_PICK)
        intentGalery.type = "image/*"
        startActivityForResult(intentGalery,Respuesta_Galeria)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == Respuesta_Galeria){
            profile_image.setImageURI(data?.data)
        }

    }
}

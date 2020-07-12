package com.applendar.applendar.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
//import com.google.firebase.auth.FirebaseAuth
import android.view.View
import android.widget.Toast
import com.applendar.applendar.MainActivity
import com.applendar.applendar.R


class LoginActivity : AppCompatActivity() {
    private lateinit var etUser: EditText
    private lateinit var etPass: EditText
    private lateinit var btLogin: Button

    private lateinit var progressBar: ProgressBar
//    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bindView()

    }

    private fun bindView(){
        etUser= findViewById(R.id.et_user)
        etPass= findViewById(R.id.et_pass)
        btLogin=findViewById(R.id.bt_login)

        progressBar=findViewById(R.id.progressBar_login)
//        auth= FirebaseAuth.getInstance()
    }
    fun forgotPassword(view: View){
        startActivity(Intent(this,ForgotActivity::class.java))
    }

    fun register(view: View){
        startActivity(Intent(this,RegisterActivity::class.java))
    }

    fun login(view: View){
//        loginUser()
        startActivity(Intent(this, MainActivity::class.java))  //borrar
    }
    private fun loginUser(){
        val user:String= etUser.text.toString()
        val password:String = etPass.text.toString()

//        if(!TextUtils.isEmpty(user)&& !TextUtils.isEmpty(password)){
//            progressBar.visibility=View.VISIBLE
//            auth.signInWithEmailAndPassword(user,password)
//                .addOnCompleteListener(this){
//                    task ->
//                    if(task.isSuccessful){
     //                   action()
//                    }else{
//                        Toast.makeText(this, "Error en la autenticacion", Toast.LENGTH_LONG).show()
//                    }
//                }
//        }
    }
    
    private fun action(){
    //    startActivity(Intent(this, MainActivity::class.java))

    }
}

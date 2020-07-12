package com.applendar.applendar.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.applendar.applendar.R
import com.applendar.applendar.databinding.ActivityMainBinding
import com.applendar.applendar.databinding.ActivityPresentationBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.bt_login
import kotlinx.android.synthetic.main.activity_presentation.*

class Presentation : AppCompatActivity() {

    private lateinit var btLogin: Button
    private lateinit var btReg: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityPresentationBinding>( this,
            R.layout.activity_presentation)
       // setContentView(R.layout.activity_main)
        bindView()

    }

    private fun bindView(){
        //btLogin=findViewById(R.id.bt_login)
        //btReg=findViewById(R.id.bt_reg)

        bt_login.setOnClickListener(){
            startActivity(Intent(this,LoginActivity::class.java))
        }
        bt_reg.setOnClickListener(){
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}

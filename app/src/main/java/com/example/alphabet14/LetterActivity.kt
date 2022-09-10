package com.example.alphabet14

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class LetterActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter)

        val resInt = intent.getIntExtra("letter", 0)

        Log.e("Djake", resInt.toString())

        val imageView: ImageView = findViewById(R.id.slideA)

        //val imageView: ImageView = findViewById(resInt)
        var bm = BitmapFactory.decodeResource(resources, resInt)
        imageView.setImageBitmap(bm)
        //val imageView: ImageView = findViewById(resInt)
        //DisplayLetter(imageView)

    }

    fun DisplayLetter(imageView: ImageView){

       // val bMap = BitmapFactory.decodeFile("/sdcard/DCIM/yuno.jpg")
       // imageView.setImageBitmap(bMap)

     //  val uri:Uri= Uri.fromFile(File(""))
       // imageView.setImageURI(uri)

    }
}
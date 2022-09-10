package com.example.alphabet14

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class LetterActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter)

        //val imageView: ImageView = findViewById(R.id.slideA)
       // DisplayLetter(imageView)

    }

    fun DisplayLetter(imageView: ImageView){

        val bMap = BitmapFactory.decodeFile("/sdcard/DCIM/yuno.jpg")
        imageView.setImageBitmap(bMap)

     //  val uri:Uri= Uri.fromFile(File(""))
       // imageView.setImageURI(uri)

    }
}
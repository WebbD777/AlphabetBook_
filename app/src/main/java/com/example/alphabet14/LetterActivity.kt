package com.example.alphabet14

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.FileNotFoundException
import java.lang.NullPointerException
import java.lang.NumberFormatException

class LetterActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letter)

        val letterNum = intent.getStringExtra("Button_number")

       var code = unicodeConversion(letterNum)
        var receiver_msg: TextView = findViewById(R.id.textView)
        receiver_msg.text = letterNum

        Toast.makeText(this@LetterActivity, letterNum, Toast.LENGTH_SHORT)

        val imageView: ImageView = findViewById(R.id.slideA)
       // if (code != null) {
        DisplayLetter(imageView, code)
       // }

    }

    fun unicodeConversion(letter: String?): String?{

        try{
        var uni:Int = letter!!.toInt()
        uni -= 64
        val character: String = uni.toString()
        var output:String = ""
        if (character.length < 2 ){
            output = "0"+character
        }

        return output
        }
        catch (e: Exception){Toast.makeText(this@LetterActivity, "WRONG!!!", Toast.LENGTH_SHORT)}
        var c = "06"
        return c
    }

    fun DisplayLetter(imageView: ImageView, code: String?){

        var bit: Bitmap //= BitmapFactory.decodeFile("/sdcard/DCIM/yuno.jpg") // To store image in storage
        val imageInSD = "/storage/emulated/0/Pictures/alphabet/Slide"+code+".gif" //Image Path

        try {

            try {
                bit = BitmapFactory.decodeFile(imageInSD) //Gets image from path

                imageView.setImageBitmap(bit) // sets Image view
            } catch (e: Exception) {
                when (e) {
                    is FileNotFoundException ->{
                        Toast.makeText(this@LetterActivity, "Letters Not Found", Toast.LENGTH_SHORT)
                            .show()}

                    is NullPointerException ->{
                        Toast.makeText(this@LetterActivity, "Letters not found", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }


        } catch (e: OutOfMemoryError) { // If image is too big for image view
            try {
                val options = BitmapFactory.Options()
                options.inSampleSize = 2 // Halfs the image
                bit= BitmapFactory.decodeFile(imageInSD, options)
                imageView.setImageBitmap(bit)
            } catch (e: Exception) {
                when (e) {
                    is FileNotFoundException ->{
                        Toast.makeText(this@LetterActivity, "Letters Not Found", Toast.LENGTH_SHORT)
                            .show()}

                    is NullPointerException ->{
                        Toast.makeText(this@LetterActivity, "Letters not found", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

    }
}
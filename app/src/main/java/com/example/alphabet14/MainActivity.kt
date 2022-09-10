package com.example.alphabet14

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.FileNotFoundException
import java.lang.NullPointerException

//import sun.net.ext.ExtendedSocketOptions.options


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonA =  findViewById(R.id.buttonA)

        buttonA.setOnClickListener(this)

      //  ActivityCompat.requestPermissions(MainActivity.this,
        //    new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE},
          //  1);

       // ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
       // checkPermission()



        /*val imageView: ImageView = findViewById(R.id.imageView)
        var bit: Bitmap //= BitmapFactory.decodeFile("/sdcard/DCIM/yuno.jpg") // To store image in storage
        val imageInSD = "/storage/emulated/0/Pictures/alphabet/Slide02.gif" //Image Path

        try {

                try {
                    bit = BitmapFactory.decodeFile(imageInSD) //Gets image from path

                    imageView.setImageBitmap(bit) // sets Image view
                } catch (e: Exception) {
                    when (e) {
                        is FileNotFoundException ->{
                        Toast.makeText(this@MainActivity, "Letters Not Found", Toast.LENGTH_SHORT)
                            .show()}

                        is NullPointerException ->{
                            Toast.makeText(this@MainActivity, "Letters not found", Toast.LENGTH_SHORT)
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
                        Toast.makeText(this@MainActivity, "Letters Not Found", Toast.LENGTH_SHORT)
                            .show()}

                    is NullPointerException ->{
                        Toast.makeText(this@MainActivity, "Letters not found", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }*/


      //  val bMap:Bitmap = BitmapFactory.decodeFile("/sdcard/DCIM/yuno.jpg")
      //  val scabit: Bitmap = Bitmap.createScaledBitmap(bMap,  50 ,50, true)
      //  imageView.setImageBitmap(scabit)



      //  switchActivity()
    }

    fun switchActivity(){

        buttonA =  findViewById(R.id.buttonA)

        buttonA.setOnClickListener{
            val intent = Intent(this,LetterActivity::class.java)
          //  intent.putExtra("SHOW_WELCOME", true)
            startActivity(intent)
          //  finish()
        }
    }

    // Function to check and request permission.
    private fun checkPermission() {
        // if (ContextCompat.checkSelfPermission(this@MainActivity, permission) == PackageManager.PERMISSION_DENIED) {
        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_DENIED
        ) {
            // Requesting the permission
            // ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )
        } else {
            Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT)
                .show()
        }

        // ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        //if (ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED)

    }

    override fun onClick(view: View?)
    {
        when ( view!!.id)
        {
            R.id.buttonA->
            {
                val intent = Intent(this,LetterActivity::class.java)
                 // intent.putExtra("key", true)
                startActivity(intent)
            }
            /*R.id.button2->
            {
                myToast("Button Two Clicked")
            }
            R.id.button3->
            {
                myToast("Button Three Clicked")
            }
            R.id.button4->
            {
                myToast("Button Four Clicked")
            }*/
        }

    }

}
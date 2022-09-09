package com.example.alphabet14

//import android.R
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*


//import sun.net.ext.ExtendedSocketOptions.options


class MainActivity : AppCompatActivity() {
    private lateinit var buttonA: Button
    private val img:String = "Slide01.gif"
    private lateinit var dir:String
    private lateinit var context: Context
    private  lateinit var bit:Bitmap
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView  = findViewById(R.id.imageView)


        val context:Context = applicationContext
       // imageView.setImageResource(R.drawable.alp)


        save(context)

        //switchActivity()
    }

    fun save(context:Context){
        var bm = BitmapFactory.decodeResource(resources, R.drawable.alphabetbook)
        //val dirPath = context.filesDir.absolutePath
        val dirPath ="/storage/emulated/0/DCIM"// Environment.DIRECTORY_DCIM
        val savPath = File(dirPath, "/alphabet")
        savPath.mkdir()

        val outFile = File(savPath, "slide.gif")


       // var file = File(dirPath, "alphabetbook.png")
        var outStream = FileOutputStream(outFile)
        bm.compress(Bitmap.CompressFormat.PNG, 75, outStream)
        outStream.flush()
        outStream.close()

        var biy = load(outFile, savPath.absolutePath.toString())
        imageView.setImageBitmap(biy)

    }

    fun load(file:File, dir:String):Bitmap {



        var fileInputStream:FileInputStream
        var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.alphabetbook)

        try{
            fileInputStream = context.openFileInput(file.absolutePath.toString());
            bitmap = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
        } catch(e:Exception) {
           // e.printStackTrace();
            Toast.makeText(this@MainActivity, "Null Bitmap", Toast.LENGTH_SHORT).show()

        }
        return bitmap

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

    /*fun insertLetterStorage(filename:String, bit:Bitmap): Boolean{

        return try {
            openFileOutput("$filename.gif", MODE_PRIVATE).use { stream ->
                 if (!bit.compress(Bitmap.CompressFormat.JPEG, 100, stream)) {
                    throw IOException("Bitmap not saved")
                 }
            }
            true
        }catch (e:IOException){
          //  Toast.makeText(Message, "Not saved, ")
            e.printStackTrace()
            false
        }

    }*/

    /*fun saveImage(){
        var dirImg = context.getDir(img, Context.MODE_PRIVATE)
       // var fileImg : File = File(dirImg, img)
        try {
            var fos:FileOutputStream = context.openFileOutput(img, MODE_PRIVATE)
            bit.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            Toast.makeText(this, "Success!!!!",
                Toast.LENGTH_LONG).show();
        }catch (e:IOException){
            e.printStackTrace()
        }
    }*/




}
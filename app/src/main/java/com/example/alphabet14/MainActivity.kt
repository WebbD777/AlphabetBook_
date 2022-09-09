package com.example.alphabet14

//import android.R
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.nfc.Tag
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*
import java.lang.Exception
import java.lang.NullPointerException
import java.lang.reflect.Field


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
        var ii = resources.getIdentifier("slide04", "drawable", packageName)
        Log.e("DAKE", ii.toString())


        save(context,loopRes())

        //switchActivity()
    }

    fun loopRes():IntArray{

        var resArrID = IntArray(26)

        for (i in 1..26){
            if (i < 10) {
                var draw: String = "slide0"+i
                //var draw: String = "drawable/slide0.gif"

                var id:Int = resources.getIdentifier(draw, "drawable", packageName)
                if (i==1){Log.e("Sheldon", id.toString())}
                resArrID[i-1] = id
            }
            else if (i >= 10){
                var draw: String = "slide"+i
                var id:Int = resources.getIdentifier(draw, "drawable", packageName)
                resArrID[i-1] = id
            }

        }

        return resArrID
       /* var idFields = R.drawable::class.typeParameters
        var resArr = IntArray(26)
        for (i in 0..25){

        }*/
    }

    fun save(context:Context, idList:IntArray){

        var count: Int = 1

        for (i in idList) {

         //   var bm = BitmapFactory.decodeResource(resources, R.drawable.slide03)
            var bm = BitmapFactory.decodeResource(resources, i)
            //val dirPath = context.filesDir.absolutePath
            val dirPath = "/storage/emulated/0/DCIM"// Environment.DIRECTORY_DCIM
            val savPath = File(dirPath, "/alphabet")
            savPath.mkdir()

            val outFile = File(savPath, "slide"+count+".gif")
            count++

            // var file = File(dirPath, "alphabetbook.png")
            var outStream = FileOutputStream(outFile)
            bm.compress(Bitmap.CompressFormat.PNG, 75, outStream)
            outStream.flush()
            outStream.close()

        }
      //  var biy = load(outFile, savPath.absolutePath.toString())
       // var biy:Bitmap = BitmapFactory.decodeFile(outFile.absolutePath.toString())
       // imageView.setImageBitmap(biy)

    }

    fun load(file:File, dir:String): Bitmap {



       // var fileInputStream:FileInputStream
        var bitmap:Bitmap= BitmapFactory.decodeResource(resources, R.drawable.alphabetbook)

        try{
            var fileInputStream = context.openFileInput(file.absolutePath.toString());
            bitmap = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
        } catch(e:Exception ) {

            when(e){
                is FileNotFoundException ->{
                    Toast.makeText(this@MainActivity, "Image not found", Toast.LENGTH_SHORT).show()
                }

                is NullPointerException ->{
                    Toast.makeText(this@MainActivity, "Null Bitmap", Toast.LENGTH_SHORT).show()
                }
            }
        //  Log.e("MainActivity",e.printStackTrace().toString())


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
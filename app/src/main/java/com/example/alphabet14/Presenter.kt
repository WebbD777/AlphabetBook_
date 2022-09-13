package com.example.alphabet14

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import kotlin.coroutines.CoroutineContext


class Presenter {
     var loadRes:loopResIds1 = loopResIds1()// lateinit var storeImgs: storeImgs

    fun setImageLetter(imageView:ImageView, context:Context){

        var bm = BitmapFactory.decodeResource(context.resources, Model.getArr()?.get(Model.getIndex()) ?:0 )
        imageView.setImageBitmap(bm)
    }

    fun getPath():String{
        return Model.getPath()
    }

    fun setImageIn(int:Int){
        Model.setIndext(int)
    }

    fun setLetterImageView(imageView: ImageView){
       // val scope: CoroutineScope = CoroutineScope)
     //   var slideNum:Int = Model.getIndex()+1
     //   var biy: Bitmap = BitmapFactory.decodeFile("/storage/emulated/0/DCIM/alphabet/slide"+slideNum+".gif")
     //   imageView.setImageBitmap(biy)
     //   joinLoopThread()
       // joinStoreThread()
        this.loadRes.join()

        var t1 = loadThread(imageView)
        t1.start()
        t1.join()
    }

    fun setImageIntLetter(int:Int){
        Model.setIndext(int)
    }

    fun setImageArr(context: Context){
        if (!Model.getCount()){
        Model.setCount()
        Model.setResIds(context)}
    }

    fun getLoopThread(loadThread: loopResIds1){

        this.loadRes=loadThread
    }

    fun getStoreThread(storeImgs: storeImgs){
     //   this.storeImgs = storeImgs
    }

    fun joinLoopThread(){
        if (this.loadRes.isAlive)
        this.loadRes.join()
    }

    fun joinStoreThread(){
       // this.storeImgs.join()
    }




}

class loadThread:Thread{
/*width="334dp"
height="393dp"
* */

    lateinit var imgView:ImageView

    constructor(imgView: ImageView) : super() {
        this.imgView=imgView
    }
    constructor()

    override fun run() {
        try {
            var options = BitmapFactory.Options()
            options.inSampleSize=2

            var slideNum: Int = Model.getIndex() + 1
            var bitSampled=
                BitmapFactory.decodeFile("/storage/emulated/0/DCIM/alphabet/slide" + slideNum + ".gif", options)
         //   var bitReSized : Bitmap = Bitmap.createBitmap(biy,0,0,334,393,matrix, false)
           // bitReSized.recycle()
            imgView.setImageBitmap(bitSampled)
        }
        catch (e:Exception){
            when(e){
                is FileNotFoundException ->{
                    Log.e("Exception", "File Not Found")
                }
            }
        }
    }

}

class loopResIds:Thread{

    lateinit var context: Context
    // lateinit var intArray: IntArray

    constructor(context: Context){
        this.context=context
        //  this.intArray=idList
    }
    constructor()

    override fun run() {
        var resArrID = IntArray(26)

        for (i in 1..26){
            if (i < 10) {
                var draw: String = "slide0"+i
                //var draw: String = "drawable/slide0.gif"

                var id:Int = context.resources.getIdentifier(draw, "drawable", context.packageName)
                if (i==1){Log.e("Sheldon", id.toString())}
                resArrID[i-1] = id
            }
            else if (i >= 10){
                var draw: String = "slide"+i
                var id:Int = context.resources.getIdentifier(draw, "drawable", context.packageName)
                resArrID[i-1] = id
            }



        }

        Model.setArr(resArrID)

    }

}

class loopResIds1:Thread{

    lateinit var context: Context
    // lateinit var intArray: IntArray

    constructor(context: Context){
        this.context=context
        //  this.intArray=idList
    }
    constructor()

    override fun run() {
        var resArrID = IntArray(26)

        for (i in 1..26){
            if (i < 10) {
                var draw: String = "slide0"+i
                //var draw: String = "drawable/slide0.gif"

                var id:Int = context.resources.getIdentifier(draw, "drawable", context.packageName)
                if (i==1){Log.e("Sheldon", id.toString())}
                resArrID[i-1] = id
            }
            else if (i >= 10){
                var draw: String = "slide"+i
                var id:Int = context.resources.getIdentifier(draw, "drawable", context.packageName)
                resArrID[i-1] = id
            }



        }

        Model.setArr(resArrID)

        var count: Int = 1

        for (i in resArrID) {

            //   var bm = BitmapFactory.decodeResource(resources, R.drawable.slide03)
            var bm = BitmapFactory.decodeResource(context.resources, i)
            //val dirPath = context.filesDir.absolutePath
            val dirPath = Model.getPath()//"/storage/emulated/0/DCIM"// Environment.DIRECTORY_DCIM
            val savPath = File(dirPath, "/alphabet")

            if(!savPath.exists()){
                savPath.mkdir()}

            val outFile = File(savPath, "slide"+count+".gif")
            count++

            // var file = File(dirPath, "alphabetbook.png")
            var outStream = FileOutputStream(outFile)
            bm.compress(Bitmap.CompressFormat.PNG, 75, outStream)
            outStream.flush()
            outStream.close()

        }

    }

}

class storeImgs:Thread{

    lateinit var context: Context
    lateinit var intArray: IntArray



    constructor(context: Context){
        this.context=context
        this.intArray=Model.getArr()
    }

    override fun run() {

            var count: Int = 1

            for (i in intArray) {

                //   var bm = BitmapFactory.decodeResource(resources, R.drawable.slide03)
                var bm = BitmapFactory.decodeResource(context.resources, i)
                //val dirPath = context.filesDir.absolutePath
                val dirPath = Model.getPath()//"/storage/emulated/0/DCIM"// Environment.DIRECTORY_DCIM
                val savPath = File(dirPath, "/alphabet")

                if(!savPath.exists()){
                    savPath.mkdir()}

                val outFile = File(savPath, "slide"+count+".gif")
                count++

                // var file = File(dirPath, "alphabetbook.png")
                var outStream = FileOutputStream(outFile)
                bm.compress(Bitmap.CompressFormat.PNG, 75, outStream)
                outStream.flush()
                outStream.close()

            }
            // /storage/emulated/0/DCIM/alphabet/slide"+count+".gif
            //  var biy = load(outFile, savPath.absolutePath.toString())
            // var biy:Bitmap = BitmapFactory.decodeFile(outFile.absolutePath.toString())
            // imageView.setImageBitmap(biy)

    }

}
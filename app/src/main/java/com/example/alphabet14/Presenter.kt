package com.example.alphabet14

/* Name: Dylan Webb
   Student Number: WBBDYL001
   Assignment: MDD1
* */

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

class Presenter {
     var loadRes:loopResIds1 = loopResIds1()

    fun setImageIn(int:Int){
        Model.setIndext(int)
    }

    fun setLetterImageView(imageView: ImageView){
        /*Starts thread to set load image from storage so main thread is not blocked
        * */

        this.loadRes.join()

        var t1 = loadThread(imageView)
        t1.start()
        t1.join()
    }

    fun setImageArr(context: Context){
        if (!Model.getCount()){
        Model.setCount()
        Model.setResIds(context)}
    }

    fun getLoopThread(loadThread: loopResIds1){
        /*Thread gets resource IDs to store images in internal phone storage
        * */

        this.loadRes=loadThread
    }

}

class loadThread:Thread{
    /*Gets requested image from storage
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

            imgView.setImageBitmap(bitSampled)
        }
        catch (e:Exception){
            when(e){
                is FileNotFoundException ->{
                    Log.e("Exception", "File Not Found")
                }
                is OutOfMemoryError ->{
                    Log.e("Exception", "Out of Memory")
                }
            }
        }
    }

}

class loopResIds1:Thread{
    /*Gets resource IDs from drawables fro images, then uses it to write images to
    internal phone storage specifically the DCMI folder
    * */

    lateinit var context: Context

    constructor(context: Context){
        this.context=context
    }
    constructor()

    override fun run() {
        var resArrID = IntArray(26)

        for (i in 1..26){
            /*Gets images res IDs and stores in array
            * */
            if (i < 10) {
                var draw: String = "slide0"+i

                var id:Int = context.resources.getIdentifier(draw, "drawable", context.packageName)
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
            /*Loop stores images to internal storage from res IDs
            * */

            var bm = BitmapFactory.decodeResource(context.resources, i)
            val dirPath = Model.getPath()
            val savPath = File(dirPath, "/alphabet")

            if(!savPath.exists()){
                savPath.mkdir()}

            val outFile = File(savPath, "slide"+count+".gif")
            count++

            var outStream = FileOutputStream(outFile)
            bm.compress(Bitmap.CompressFormat.PNG, 75, outStream)
            outStream.flush()
            outStream.close()

        }

    }

}
package com.example.alphabet14

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream


class Presenter {

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
     //   var slideNum:Int = Model.getIndex()+1
     //   var biy: Bitmap = BitmapFactory.decodeFile("/storage/emulated/0/DCIM/alphabet/slide"+slideNum+".gif")
     //   imageView.setImageBitmap(biy)
        var t1 = loadThread(imageView)
        t1.start()
    }

    fun setImageIntLetter(int:Int){
        Model.setIndext(int)
    }

    fun setImageArr(context: Context){
        if (!Model.getCount()){
        Model.setCount()
        Model.setResIds(context)}
    }




}

class loadThread:Thread{

    lateinit var imgView:ImageView

    constructor(imgView: ImageView) : super() {
        this.imgView=imgView
    }

    override fun run() {
        var slideNum:Int = Model.getIndex()+1
        var biy: Bitmap = BitmapFactory.decodeFile("/storage/emulated/0/DCIM/alphabet/slide"+slideNum+".gif")
        imgView.setImageBitmap(biy)
    }

}

class storeImgs:Thread(){

    override fun run() {

    }

}
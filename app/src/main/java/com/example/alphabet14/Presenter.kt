package com.example.alphabet14

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity


class Presenter {

    fun setImageLetter(imageView:ImageView, context:Context){

        var bm = BitmapFactory.decodeResource(context.resources, Model.getArr()?.get(Model.getIndex()) ?:0 )
        imageView.setImageBitmap(bm)
    }

    fun setImageIn(int:Int){
        Model.setIndext(int)
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
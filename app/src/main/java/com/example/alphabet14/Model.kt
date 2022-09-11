package com.example.alphabet14

import android.content.Context
import android.content.Intent
import android.util.Log

class Model{

    companion object{
        private lateinit var rIdArray: IntArray
        private var rIndext: Int = 0
        private var count: Boolean = false
        private lateinit var intent: Intent
        private lateinit var context: Context
        private var storagePath = "/storage/emulated/0/DCIM"

        fun getPath():String{
            return storagePath
        }

        fun setIntent(intent: Intent){
            this.intent=intent
        }

        fun setContect(context: Context){
            this.context=context
        }

        fun getIntent():Intent{
            return intent
        }

        fun getIndex():Int{
            return rIndext
        }

        fun setIndext(int:Int){
            rIndext=int
        }

        fun getArr(): IntArray {
            return rIdArray
        }

        fun setArr(intArray: IntArray){
            this.rIdArray=intArray
        }

        fun setCount(){
            count = true
        }

        fun getCount():Boolean{
            return count
        }

        fun setResIds(context: Context){

            var resArrID = IntArray(26)

            for (i in 1..26){
                if (i < 10) {
                    var draw: String = "slide0"+i
                    //var draw: String = "drawable/slide0.gif"

                    var id:Int = context.resources.getIdentifier(draw, "drawable", context.packageName)
                    if (i==1){
                        Log.e("Sheldon", id.toString())}
                    resArrID[i-1] = id
                }
                else if (i >= 10){
                    var draw: String = "slide"+i
                    var id:Int = context.resources.getIdentifier(draw, "drawable", context.packageName)
                    resArrID[i-1] = id
                }

            }
            rIdArray = resArrID
        }
    }

}
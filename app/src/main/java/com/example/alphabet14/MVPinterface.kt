package com.example.alphabet14

import android.content.Intent

class MVPinterface {

    interface View{


    }

    interface PresenterMode{

    }

    interface Model{

        fun rIdArray():IntArray
        fun rIdIndex():Int
        fun intentState():Intent

    }
}
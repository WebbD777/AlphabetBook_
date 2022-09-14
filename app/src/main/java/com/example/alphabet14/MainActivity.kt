package com.example.alphabet14

/* Name: Dylan Webb
   Student Number: WBBDYL001
   Assignment: MDD1
* */

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        var sp: SharedPreferences = getSharedPreferences("myActivity", Context.MODE_PRIVATE)


        var spEdit: SharedPreferences.Editor = sp.edit()

        if (sp.getString("activity", "p").equals("LetterActivity")){
            var st:String = sp.getString("activity", "p")!!

            val intent = Intent(this@MainActivity,Class.forName("com.example.alphabet14.${st}").kotlin.java)

            presenter.setImageIn(sp.getInt("letter", 0))
            startActivity(intent)
            finish()
        }

      else if (!sp.contains("acitivity") || sp.getString("activity", "p").equals("OverviewActivity")) {
            spEdit.putString("activity", "OverviewActivity")
            spEdit.commit()


                var st:String = sp.getString("activity", "")!!

                val intent = Intent(this@MainActivity, Class.forName("com.example.alphabet14.${st}").kotlin.java)

                startActivity(intent)
                finish()

            }

            super.onCreate(savedInstanceState)
        }

    }

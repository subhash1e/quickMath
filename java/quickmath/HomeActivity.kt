package com.subhash1e.quickmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val rg1 = findViewById<RadioGroup>(R.id.rgAlgo)
        val rg2 = findViewById<RadioGroup>(R.id.rgDifficulty)


        btnStart.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            var algo=0
            var level=0
            when(rg1.checkedRadioButtonId){
                R.id.rbAdd->{
                    algo=0
                }
                R.id.rbSubtract->{
                    algo=1
                }
                R.id.rbMultiply->{
                    algo=2
                }

            }
            when(rg2.checkedRadioButtonId){
                R.id.rblevel1->{
                    level=0
                }
                R.id.rblevel2->{
                    level=1
                }
                R.id.rblevel3->{
                    level=2
                }

            }
            intent.putExtra("level",level+1)
            intent.putExtra("algo",algo+1)


            startActivity(intent)
        }
    }
}
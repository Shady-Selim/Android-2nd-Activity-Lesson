package com.shady.w3d4l1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var resultButton: Button
    private lateinit var gogBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val txt = intent.getStringExtra(getString(R.string.INTENT_VARIABLE))
        textView = findViewById(R.id.txtView)
        textView.text = txt

        resultButton = findViewById(R.id.btnResult)
        resultButton.setOnClickListener {
            val data = Intent().putExtra(getString(R.string.HELLO_BACK),
                "Hello back ya Pasha")
            setResult(Activity.RESULT_OK, data)
            finish()
        }

        gogBackButton = findViewById(R.id.btnFirstActivity)
        gogBackButton.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }


    }

}
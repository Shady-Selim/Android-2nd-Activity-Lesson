package com.shady.w3d4l1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    private lateinit var secondScreenButton: ImageButton
    private lateinit var requestResultButton: Button
    private lateinit var textView: TextView
    private val requestCodeVar = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        secondScreenButton = findViewById(R.id.btnGoToPage2)
        requestResultButton = findViewById(R.id.btnReturnResult)

        secondScreenButton.setOnClickListener {
            textView.text = "button start activity clicked"
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra(getString(R.string.INTENT_VARIABLE),
                "Hello ya 2nd activity")
            startActivity(i)

        }
        requestResultButton.setOnClickListener {
            textView.text = "button start activity for result clicked"
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra(getString(R.string.INTENT_VARIABLE),
                "Hello ya 2nd activity")
            startActivityForResult(i, requestCodeVar)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK){
            if (requestCode == requestCodeVar)
                textView.text = data?.getStringExtra(getString(R.string.HELLO_BACK))
        } else {
            textView.text = "It said no"
        }
    }
}
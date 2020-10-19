package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val buttons : ArrayList<Button> = arrayListOf<Button>();
    private lateinit var screen : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screen = findViewById(R.id.screen);
        getCalculatorButtons();

        Log.d("Test", buttons[0].text.toString());
    }


    fun getCalculatorButtons(){
        for(i in 1..9){
            val buttonId = "button"+i;
            val viewId = resources.getIdentifier(buttonId, "id", packageName);
            val button = findViewById<Button>(viewId) as Button;
            button.setOnClickListener(printButtonToScreen);
            buttons.add(button);
        }
    }

    val printButtonToScreen = View.OnClickListener{view ->
        val button = view.findViewById<Button>(view.id);
        updateScreen(button.text.toString());
    }

    fun updateScreen(text : String){
        screen.append(text);
    }
}
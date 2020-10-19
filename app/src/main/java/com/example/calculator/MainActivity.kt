package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculator.util.Calculation

class MainActivity : AppCompatActivity() {

    private val buttons : ArrayList<Button> = arrayListOf<Button>();
    private lateinit var screen : TextView;
    private lateinit var calculation: Calculation;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val removeButton = findViewById<Button>(R.id.remove) as Button;
        val plusButton = findViewById<Button>(R.id.add) as Button
        val minusButton = findViewById<Button>(R.id.minus) as Button
        val divideButton = findViewById<Button>(R.id.divide) as Button
        val timesButton = findViewById<Button>(R.id.times) as Button
        val calcButton = findViewById<Button>(R.id.calc) as Button;

        calculation = Calculation();

        removeButton.setOnClickListener(removeNumberFromScreen);
        calcButton.setOnClickListener(calculateNumbersOnScreen);

        plusButton.setOnClickListener(printButtonToScreen);
        minusButton.setOnClickListener(printButtonToScreen);
        divideButton.setOnClickListener(printButtonToScreen);
        timesButton.setOnClickListener(printButtonToScreen);

        screen = findViewById(R.id.screen);
        getCalculatorButtons();
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

    fun updateScreen(text : String){
        screen.append(text);
    }

    val printButtonToScreen = View.OnClickListener{view ->
        val button = view.findViewById<Button>(view.id);
        updateScreen(button.text.toString());
    }

    val removeNumberFromScreen = View.OnClickListener { view ->
        screen.text = screen.text.dropLast(1);
    }

    val calculateNumbersOnScreen = View.OnClickListener { view ->
        val reg = Regex("(?<=[+/*-])|(?=[+/*-])")
        val values = screen.text.split(reg);
        val a = values[0].toString().toDouble();
        val calc = values[1].toString();
        val b = values[2].toString().toDouble();

        val output = calculation.checkCalculation(a, b, calc);
        screen.text = output.toString();
    }
}
package com.example.calculator.util

class Calculation(){
    fun addition(a : Double, b : Double): Double {
        return a + b;
    }

    fun substract(a : Double, b : Double) : Double {
        return a - b;
    }

    fun divide(a : Double, b : Double) : Double {
        return a / b;
    }

    fun times(a : Double, b : Double) : Double {
        return a * b;
    }

    fun checkCalculation(a : Double, b : Double, calc : String) : Double {
        when(calc){
            in "+" -> return addition(a, b);
            in "*" -> return times(a, b);
            in "/" -> return divide(a, b);
            in "-" -> return substract(a, b);
        }
        return 0.0;
    }
}
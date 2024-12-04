package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operand1Input = findViewById<EditText>(R.id.operand1Input)
        val operand2Input = findViewById<EditText>(R.id.operand2Input)
        val resultView = findViewById<TextView>(R.id.resultView)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        // Set up button click listeners
        addButton.setOnClickListener {
            performOperation(operand1Input, operand2Input, Operations.ADD, resultView)
        }

        subtractButton.setOnClickListener {
            performOperation(operand1Input, operand2Input, Operations.SUBTRACT, resultView)
        }

        multiplyButton.setOnClickListener {
            performOperation(operand1Input, operand2Input, Operations.MULTIPLY, resultView)
        }

        divideButton.setOnClickListener {
            performOperation(operand1Input, operand2Input, Operations.DIVIDE, resultView)
        }
    }

    private fun performOperation(
        operand1Input: EditText,
        operand2Input: EditText,
        operation: Operations,
        resultView: TextView
    ) {
        val operand1 = operand1Input.text.toString().toDoubleOrNull()
        val operand2 = operand2Input.text.toString().toDoubleOrNull()

        if (operand1 == null || operand2 == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val calculator = Calculator(operand1, operand2)

        try {
            val result = calculator.performOperation(operation)
            resultView.text = "Result: $result"
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }
}
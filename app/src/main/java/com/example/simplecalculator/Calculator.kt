package com.example.simplecalculator

// Enum class defining the operations
enum class Operations {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

// Calculator class
class Calculator(private val operand1: Double, private val operand2: Double) {

    // Function to perform the operation
    fun performOperation(operation: Operations): Double {
        return when (operation) {
            Operations.ADD -> operand1 + operand2
            Operations.SUBTRACT -> operand1 - operand2
            Operations.MULTIPLY -> operand1 * operand2
            Operations.DIVIDE -> {
                if (operand2 != 0.0) {
                    operand1 / operand2
                } else {
                    throw IllegalArgumentException("Division by zero is not allowed.")
                }
            }
        }
    }
}
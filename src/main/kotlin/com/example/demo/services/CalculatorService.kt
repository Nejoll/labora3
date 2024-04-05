package com.example.demo.services

import org.springframework.stereotype.Service

@Service
class CalculatorService {
    
    fun plus(a: Double, b: Double): Double {
        return a + b
    }
    
    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    fun divide(a: Double, b: Double): Double {
        if(b.toInt() == 0)
            throw IllegalArgumentException("b cannot be 0")

        return a / b
    }
}
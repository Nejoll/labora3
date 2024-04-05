package com.example.demo.controllers

import com.example.demo.services.CalculatorService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CalculatorControllerTest {

    private val controller = CalculatorController(CalculatorService())

    @Test
    fun calculateWhenPlusOp() {

        var res = controller.calculate(5.0, 6.0, "plus").toDouble()
        Assertions.assertEquals(11.0, res)

        res = controller.calculate(5.0, -6.0, "plus").toDouble()
        Assertions.assertEquals(-1.0, res)

        res = controller.calculate(-5.0, -6.0, "plus").toDouble()
        Assertions.assertEquals(-11.0, res)
    }

    @Test
    fun calculateWhenSubOp() {

        var res = controller.calculate(5.0, 6.0, "sub").toDouble()
        Assertions.assertEquals(-1.0, res)

        res = controller.calculate(5.0, -6.0, "sub").toDouble()
        Assertions.assertEquals(11.0, res)

        res = controller.calculate(-5.0, -6.0, "sub").toDouble()
        Assertions.assertEquals(1.0, res)
    }

    @Test
    fun calculateWhenMulOp() {

        var res = controller.calculate(5.0, 6.0, "mul").toDouble()
        Assertions.assertEquals(30.0, res)

        res = controller.calculate(0.0, 1.0, "mul").toDouble()
        Assertions.assertEquals(0.0, res)

        res = controller.calculate(5.0, -6.0, "mul").toDouble()
        Assertions.assertEquals(-30.0, res)
    }

    @Test
    fun calculateWhenDivOp() {

        var res = controller.calculate(55.0, 5.0, "div").toDouble()
        Assertions.assertEquals(11.0, res)

        res = controller.calculate(0.0, 1.0, "div").toDouble()
        Assertions.assertEquals(0.0, res)

        res = controller.calculate(5.0, -5.0, "div").toDouble()
        Assertions.assertEquals(-1.0, res)

        val resStr = controller.calculate(1.0, 0.0, "div")
        Assertions.assertTrue(resStr.toDoubleOrNull() == null) // То есть какая-то строка, не число
    }
}
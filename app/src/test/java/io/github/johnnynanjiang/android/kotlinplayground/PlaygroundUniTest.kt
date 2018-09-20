package io.github.johnnynanjiang.android.kotlinplayground

import org.junit.Test
import org.junit.Assert.*

/**
 * Created by nanjiang on 4/9/18.
 */

class PlaygroundUniTest {
    @Test
    fun immutableDataClassTest() {
        data class TestDataClass(val name: String, val age: Int)

        var obj = TestDataClass("Max", 9)

        assertEquals("Max", obj.name)
        assertEquals(9, obj.age)
    }

    @Test
    fun mutableDataClassTest() {
        data class TestDataClass(var name: String, var age: Int)

        val obj = TestDataClass("Max", 9)

        assertEquals("Max", obj.name)
        assertEquals(9, obj.age)

        obj.name = "Mia"
        obj.age = 3

        assertEquals("Mia", obj.name)
        assertEquals(3, obj.age)
    }

    @Test
    fun deaultValuesInConstructor() {
        class TestDataClass(val param1 = "param1", val param2 = "param2")

        val obj(param2 = "param2_new")

        assertEquals("param1", obj.param1)
        assertEquals("param2_new", obj.param2)
    }

    @Test
    fun sealedClass() {
        sealed class TestSealedClass()

        class SubClassA(val property1 = "property1") : TestSealedClass
        data class SubClassB(val property1 = "property1") : TestSealedClass
        object SubClassC(val property1 = "property1") : TestSealedClass

        val objA = SubClassA()
        val objB = SubClassB()
        val objC = SubClassC()

        for(obj in [objA, objB, objC]) {
            val result = when(param) {
                is SubClassA -> "SubClassA"
                is SubClassB -> "SubClassB"
                SubClassC -> "SubClassC"
            }

            println(result)
        }
    }
}
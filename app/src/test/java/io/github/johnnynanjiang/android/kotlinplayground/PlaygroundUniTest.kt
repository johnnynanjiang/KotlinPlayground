package io.github.johnnynanjiang.android.kotlinplayground

import org.junit.Test
import org.junit.Assert.*

/**
 * Created by nanjiang on 4/9/18.
 */
class PlaygroundUniTest {
    @Test
    fun immutableDataClass() {
        data class TestDataClass(val name: String, val age: Int)

        var obj = TestDataClass("Max", 9)

        assertEquals("Max", obj.name)
        assertEquals(9, obj.age)
    }

    @Test
    fun mutableDataClass() {
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
    fun defaultValuesInConstructor() {
        class TestDataClass(val param1:String = "param1", val param2:String = "param2")

        val obj = TestDataClass(param2 = "param2_new")

        assertEquals("param1", obj.param1)
        assertEquals("param2_new", obj.param2)
    }

    sealed class TestSealedClass {
        class SubClassA(val property1:String = "property1") : TestSealedClass()
        data class SubClassB(val property1:String = "property1") : TestSealedClass()
        object SubClassC : TestSealedClass()
    }

    @Test
    fun sealedClass() {
        val objA = TestSealedClass.SubClassA()
        val objB = TestSealedClass.SubClassB()
        val objC = TestSealedClass.SubClassC

        arrayOf(objA, objB, objC)
                .map {
                    when(it) {
                        is TestSealedClass.SubClassA -> "SubClassA"
                        is TestSealedClass.SubClassB -> "SubClassB"
                        is TestSealedClass.SubClassC -> "SubClassC"
                    }
                }
                .forEach { println(it) }
    }

    @Test
    fun generics() {
        fun <T> print(lhs: T, rhs: T) = println("$lhs, $rhs")

        print<String>("a", "b")
        print<Int>(1, 2)
        print<Float>(1.1f, 2.2f)
        print<Number>(1.11, 2.22)
    }
}
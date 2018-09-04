package io.github.johnnynanjiang.android.kotlinplayground

import org.junit.Test
import org.junit.Assert.*

/**
 * Created by nanjiang on 4/9/18.
 */

class PlaygroundUniTest {
    data class ImmutableDataClass(val name: String, val age: Int)
    data class MutableDataClass(var name: String, var age: Int)

    @Test
    fun immutableDataClassTest() {
        var objOfImmutableDataClass = ImmutableDataClass("Max", 9)

        assertEquals("Max", objOfImmutableDataClass.name)
        assertEquals(9, objOfImmutableDataClass.age)
    }

    @Test
    fun mutableDataClassTest() {
        val objOfMutableDataClass = MutableDataClass("Max", 9)

        assertEquals("Max", objOfMutableDataClass.name)
        assertEquals(9, objOfMutableDataClass.age)

        objOfMutableDataClass.name = "Mia"
        objOfMutableDataClass.age = 3

        assertEquals("Mia", objOfMutableDataClass.name)
        assertEquals(3, objOfMutableDataClass.age)
    }
}
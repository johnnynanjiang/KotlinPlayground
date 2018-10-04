package io.github.johnnynanjiang.android.kotlinplayground

import io.reactivex.Observable
import org.junit.Test
import org.junit.Assert.*

/**
 * Created by nanjiang on 28/9/18.
 */
class RxUnitTest {
    @Test
    fun testRxJava() {
        val observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter { it > 3 }
                .map {
                    println("map on ($it)")
                    it
                }
        observable.subscribe(
                { item -> println("subscriber1 next on ($item)") },
                { item -> println("subscriber1 error on ($item)") },
                { println("subscriber1 finally complete") }
        )

        observable.subscribe(
                { item -> println("subscriber2 next on ($item)") },
                { item -> println("subscriber2 error on ($item)") },
                { println("subscriber2 finally complete") }
        )
    }
}

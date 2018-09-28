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
                .map { println("map($it)") }
        val subscriber1 = observable.subscribe { println("subscriber1 complete") }
        val subscriber2 = observable.subscribe { println("subscriber2 complete") }
    }
}

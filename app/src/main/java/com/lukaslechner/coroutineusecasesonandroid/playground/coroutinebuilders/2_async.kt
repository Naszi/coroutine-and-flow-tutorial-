package com.lukaslechner.coroutineusecasesonandroid.playground.coroutinebuilders

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
//    // It's parallel
//    val startTime = System.currentTimeMillis()
//    val resultList = mutableListOf<String>()
//    val job1 = launch {
//        val result1 = networkCall(1)
//        resultList.add(result1)
//        println("result received: $result1 after ${elapsedMillis(startTime)}ms")
//    }
//    val job2 = launch {
//        val result2 = networkCall(2)
//        resultList.add(result2)
//        println("result received: $result2 after ${elapsedMillis(startTime)}ms")
//    }
//    job1.join()
//    job2.join()
//    println("Result list: $resultList after ${elapsedMillis(startTime)}ms")

    // It's async
    val startTime = System.currentTimeMillis()
    val deferred1 = async(start = CoroutineStart.LAZY) {
        val result1 = networkCall(1)
        println("result received: $result1 after ${elapsedMillis(startTime)}ms")
        result1
    }
    val deferred2 = async() {
        val result2 = networkCall(2)
        println("result received: $result2 after ${elapsedMillis(startTime)}ms")
        result2
    }
    deferred1.start()
    val resultList = listOf(deferred1.await(), deferred2.await())
    println("Result list: $resultList after ${elapsedMillis(startTime)}ms")

}

suspend fun networkCall(number: Int): String {
    delay(500)
    return "Result $number"
}

fun elapsedMillis(startTime: Long) = System.currentTimeMillis() - startTime
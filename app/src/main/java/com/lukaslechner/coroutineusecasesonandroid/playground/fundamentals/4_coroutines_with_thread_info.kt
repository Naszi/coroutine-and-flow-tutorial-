package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

/**
 * Coroutine: A coroutine is a generalization of a subroutine (routine)
 * that can pause its execution at certain points and allow other code
 * to run before it resumes. This allows for cooperative multitasking,
 * where different parts of a program can run concurrently without requiring
 * separate threads or processes. Coroutines can yield control back to the caller,
 * and the caller can later resume the coroutine from where it left off.
 * */

fun main() = runBlocking {
    println("main starts")
    joinAll(
        async { coroutineWithThreadInfo(1, 500) },
        async { coroutineWithThreadInfo(2, 300) }
    )
    println("main ends")
}

suspend fun coroutineWithThreadInfo(number: Int, delay: Long) {
    println("Coroutine $number starts work on ${Thread.currentThread().name}")
    delay(delay)
    println("Coroutine $number has finished on ${Thread.currentThread().name}")
}
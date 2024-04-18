package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

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
        async { threadSwitchingCoroutine(1, 500) },
        async { threadSwitchingCoroutine(2, 300) }
    )
    println("main ends")
}

suspend fun threadSwitchingCoroutine(number: Int, delay: Long) {
    println("Coroutine $number starts work on ${Thread.currentThread().name}")
    delay(delay)
    withContext(Dispatchers.Default) {
        println("Coroutine $number has finished on ${Thread.currentThread().name}")
    }
}
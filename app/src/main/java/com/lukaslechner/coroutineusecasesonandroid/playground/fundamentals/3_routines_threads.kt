package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

import kotlin.concurrent.thread

/**
 * Routine: A routine is a sequence of instructions or operations that are
 * executed sequentially, typically representing a function or a method in
 * a programming language. In a traditional synchronous program, routines are
 * executed one after the other, with each routine completing before
 * the next one begins.
 * */

fun main() {
    println("main starts")
    threadRoutine(1, 500)
    threadRoutine(2, 300)
    Thread.sleep(1000)
    println("main ends")
}

fun threadRoutine(number: Int, delay: Long) {
    thread {
        println("Routine $number starts work")
        Thread.sleep(delay)
        println("Routine $number has finished")
    }
}
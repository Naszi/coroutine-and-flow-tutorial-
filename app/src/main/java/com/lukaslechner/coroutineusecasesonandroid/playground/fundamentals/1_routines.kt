package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

/**
 * Routine: A routine is a sequence of instructions or operations that are
 * executed sequentially, typically representing a function or a method in
 * a programming language. In a traditional synchronous program, routines are
 * executed one after the other, with each routine completing before
 * the next one begins.
 * */

fun main() {
    println("main starts")
    routine(1, 500)
    routine(2, 300)
    println("main ends")
}

fun routine(number: Int, delay: Long) {
    println("Routine $number starts work")
    Thread.sleep(delay)
    println("Routine $number has finished")
}
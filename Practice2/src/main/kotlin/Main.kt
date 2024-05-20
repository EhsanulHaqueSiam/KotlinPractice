package org.example

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default

val handler =
    CoroutineExceptionHandler { _, exception -> println("Error in one of the children: ${exception.message}") }

fun main() {// executed on the main thread
    println("Main program starts: ${Thread.currentThread().name}")

    val start = System.currentTimeMillis()

//    thread {
//        println("Fake work starts: ${Thread.currentThread().name}")
//
//        Thread.sleep(2000)// pretending to do some work
//
//        println("Fake work finished: ${Thread.currentThread().name}")
//    }
//    val parentJob= CoroutineScope(Default).launch { // Group Coroutine //Main//IO//Default
//        println("Fake work starts: ${Thread.currentThread().name}")
//
////        Thread.sleep(2000)// pretending to do some work
//        delay(2000)// just pause this specific coroutine //suspend function only call from coroutine / check by pressing CTRL
//        println("Fake work finished: ${Thread.currentThread().name}")
//    }
//    val globalScope = GlobalScope.launch {
//        val job1: Job = GlobalScope.launch {
//            getData(Thread.currentThread().name)
//
//        }
//    }
    val parentJob = CoroutineScope(Default).launch(handler) {// handler to for exceptions
        val job1 = launch {
            try {
                val result1 = getData(Thread.currentThread().name)
                println(result1)

            } catch (ex: CancellationException) {
                println("Exception caught safely: ${ex.message}")
            } finally {
                println("Resources closed safely.")
            }
            if (!isActive) {// check is coroutine is active
                return@launch // return to lunch
            }
        }
//        job1.cancel()
//        job1.cancel(CancellationException("My own error message"))
//        job1.join()
//        job1.cancelAndJoin()
        val job2 = launch {
            val result = getData2(Thread.currentThread().name)
            println(result)
        }
        val job3 = withTimeout(1000) {
            val result = getData2(Thread.currentThread().name)
            println(result)
        }
        val job4 = withTimeoutOrNull(1000) {
            val result = getData2(Thread.currentThread().name)
            println(result)
            12
        }
        println(job4)
        val jobDeferred1: Deferred<String> = async {
            getData(Thread.currentThread().name)

        }
        val jobDeferred2: Deferred<String> = async {
            getData2(Thread.currentThread().name)
        }
        println(jobDeferred1.await() + "\n ${jobDeferred2.await()}")

        supervisorScope {// one exception doesn't make the other coroutines to a halt
            val job5 = launch {
                println(getData3(Thread.currentThread().name))
            }
        }
    }
//    Thread.sleep(2500)
    runBlocking {
        parentJob.join()
    }
    parentJob.invokeOnCompletion {
        it?.let {
            println("Parent job FAILED: ${it.message}")
        } ?: println("Parent job SUCCESS!")
    }
    println("Total time: ${System.currentTimeMillis() - start}")
    println("Main program ends: ${Thread.currentThread().name}")
}

private suspend fun getData(threadName: String): String {
    println("Fake work1 starts: $threadName")
    delay(2000)
    println("Fake work1 finished: $threadName")
    return "Result 1"
}

private suspend fun getData2(threadName: String): String {
    println("Fake work2 starts: $threadName")
    delay(2000)// Thread.sleep is not part of kotlinx.coroutines so not co-operative but delay is
    println("Fake work2 finished: $threadName")
    return "Result 2"
}

private suspend fun getData3(threadName: String): String {
    println("Fake work3 starts: $threadName")
//    throw Exception("Error while getting the data in getData3()")
    throw CancellationException("Error while getting the data in getData3()")
    delay(2000)// Thread.sleep is not part of kotlinx.coroutines so not co-operative but delay is
    println("Fake work3 finished: $threadName")
    return "Result 3"
}


package org.example

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.Main

val handler2 =
    CoroutineExceptionHandler { _, exception -> println("Error in one of the children: ${exception.message}") }

fun main() {// executed on the main thread
    println("Main program starts: ${Thread.currentThread().name}")

    val start = System.currentTimeMillis()
// by default parallel
//    val parentJob = CoroutineScope(Default).launch(handler2) {// handler to for exceptions
//        val job1 = launch {
//            println(getData(Thread.currentThread().name))
//
//        }
//        job1.join()
//        val job2 = launch {
//            println(getData2(Thread.currentThread().name))
//        }
//        job2.join()
//        val job3 = launch {
//            println(getData3(Thread.currentThread().name))
//        }
//
//    }

    val parentJob = CoroutineScope(Default).launch(handler2) {// handler to for exceptions
        val job1 = async(start = CoroutineStart.LAZY) {
            getData(Thread.currentThread().name)

        }
        job1.join()
        val job2 = async(start = CoroutineStart.LAZY) {
            getData2(Thread.currentThread().name)
        }
        job2.join()
        val job3 = async(start = CoroutineStart.LAZY) {
            getData3(Thread.currentThread().name)
        }

        println("${job1.await()} \n ${job2.await()} \n ${job3.await()}") //  SHIFT+CTRL+P to check what it returns

    }

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

    delay(2000)// Thread.sleep is not part of kotlinx.coroutines so not co-operative but delay is
    println("Fake work3 finished: $threadName")
    return "Result 3"
}

private suspend fun setTextOnMainThread(input: String){
    withContext(Main){// switch the thread

    }
}


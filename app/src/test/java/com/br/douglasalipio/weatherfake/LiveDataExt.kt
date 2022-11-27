package com.br.douglasalipio.weatherfake

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import org.junit.Assert
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/* Copyright 2019 Google LLC.
   SPDX-License-Identifier: Apache-2.0 */
fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(observedData: T?) {
            data = observedData
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke()

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }
    } finally {
        this.removeObserver(observer)
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}

fun <T> LiveData<T>.assertNotEmitted(
    time: Long = 10,
    timeUnit: TimeUnit = TimeUnit.MILLISECONDS
) {
    try {
        getOrAwaitValue(time, timeUnit)
        Assert.assertTrue(false)
    } catch (exception: TimeoutException) {
        Assert.assertTrue(true)
    }
}

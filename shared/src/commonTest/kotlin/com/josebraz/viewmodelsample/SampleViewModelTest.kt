package com.josebraz.viewmodelsample

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.*
import kotlinx.coroutines.yield
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class SampleViewModelTest {

    @Test
    fun incrementTest() {
        val viewModel = SampleViewModel()
        assertEquals(0, viewModel.stateFlow.value.counter)
        viewModel.increment()
        assertEquals(1, viewModel.stateFlow.value.counter)
    }

    @Test
    fun startClockTest() = runTest {
        val viewModel = SampleViewModel(
            UnconfinedTestDispatcher(this.testScheduler)
        ) { Instant.fromEpochMilliseconds(this.currentTime) }

        viewModel.startClock()
        assertEquals("00", viewModel.stateFlow.value.time.takeLast(2))

        advanceTimeBy(1000)
        yield() // change to startClock coroutine
        assertEquals("01", viewModel.stateFlow.value.time.takeLast(2))

        advanceTimeBy(1000)
        yield() // change to startClock coroutine
        assertEquals("02", viewModel.stateFlow.value.time.takeLast(2))

        viewModel.viewModelScope.cancel()
    }
}
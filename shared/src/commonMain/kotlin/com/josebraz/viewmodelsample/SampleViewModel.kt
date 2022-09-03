package com.josebraz.viewmodelsample

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.coroutines.CoroutineContext

data class SampleViewState(
    val counter: Int,
    val time: String
) {
    constructor(): this(0, "")
}

class SampleViewModel(
    private val clockContext: CoroutineContext,
    private val currentTime: () -> Instant
): PlatformViewModel() {

    constructor(): this(
        defaultViewModelContext,
        { Clock.System.now() }
    )

    val stateFlow = StateFlowWrapper(SampleViewState())

    fun startClock() {
        viewModelScope.launch(clockContext) {
            val timezone = TimeZone.currentSystemDefault()
            while (true) {
                stateFlow.update {
                    val time = currentTime().toLocalDateTime(timezone).time
                    stateFlow.value.copy(
                        time = "${("0" + time.hour).takeLast(2)}:" +
                                "${("0" + time.minute).takeLast(2)}:" +
                                ("0" + time.second).takeLast(2)
                    )
                }
                delay(1000)
            }
        }
    }

    fun increment() {
        stateFlow.update {
            stateFlow.value.copy(counter = stateFlow.value.counter + 1)
        }
    }
}


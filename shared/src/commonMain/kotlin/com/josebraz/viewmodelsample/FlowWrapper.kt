package com.josebraz.viewmodelsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

interface FlowWrapper<T>: Flow<T> {

    fun collectState(collector: (T) -> Unit) {
        collectState(
            CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate),
            collector
        )
    }

    fun collectState(scope: CoroutineScope, collector: (T) -> Unit)

    fun cancelCollect()
}

class FlowWrapperImpl<T>(
    private val flow: Flow<T>
): FlowWrapper<T>, Flow<T> by flow {

    private var collectJob: Job? = null

    override fun collectState(
        scope: CoroutineScope,
        collector: (T) -> Unit
    ) {
        collectJob = scope.launch {
            flow.collect(collector)
        }
    }

    override fun cancelCollect() {
        collectJob?.cancel()
        collectJob = null
    }
}

class StateFlowWrapper<T>(
    private val flow: MutableStateFlow<T>
): FlowWrapper<T>, MutableStateFlow<T> by flow {

    private val wrapper = FlowWrapperImpl(flow)

    constructor(value: T): this(MutableStateFlow(value))

    fun updateState(newValue: T) {
        flow.update { newValue }
    }

    override fun collectState(scope: CoroutineScope, collector: (T) -> Unit) {
        wrapper.collectState(scope, collector)
    }

    override fun cancelCollect() = wrapper.cancelCollect()

}
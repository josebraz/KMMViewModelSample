package com.josebraz.viewmodelsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

actual open class PlatformViewModel {
    private val scope = CoroutineScope(SupervisorJob() + defaultViewModelContext)

    actual val viewModelScope: CoroutineScope = scope

    protected actual open fun onCleared() {
    }

    fun clean() {
        scope.cancel()
        onCleared()
    }
}
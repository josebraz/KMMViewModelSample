package com.josebraz.viewmodelsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

val defaultViewModelContext = Dispatchers.Main.immediate

expect open class PlatformViewModel constructor() {
    val viewModelScope: CoroutineScope

    protected open fun onCleared()
}

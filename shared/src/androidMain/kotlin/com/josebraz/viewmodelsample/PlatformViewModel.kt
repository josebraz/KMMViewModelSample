package com.josebraz.viewmodelsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope as nativeScope
import kotlinx.coroutines.CoroutineScope

actual open class PlatformViewModel: ViewModel() {
    actual val viewModelScope: CoroutineScope = this.nativeScope

    actual override fun onCleared() {
    }

}

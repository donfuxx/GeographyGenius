package com.appham.geographygenius.common.utils

import androidx.lifecycle.LiveData

interface LiveDataObserver {

    fun <T> LiveData<T>.observe(onChange: (T) -> Unit)
}
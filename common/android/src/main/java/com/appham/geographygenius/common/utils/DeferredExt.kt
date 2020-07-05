package com.appham.geographygenius.common.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.launch

fun <T> Deferred<T>.withScope(scope: CoroutineScope, block: T.() -> Unit) {
    scope.launch {
        with (this@withScope.await()) { block() }
    }
}
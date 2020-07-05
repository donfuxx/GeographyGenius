package com.appham.geographygenius.common.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

fun <T> lazyWithScope(scope: CoroutineScope, initializer: suspend () -> T): Lazy<Deferred<T>> = lazy {
    scope.async {
        initializer()
    }
}
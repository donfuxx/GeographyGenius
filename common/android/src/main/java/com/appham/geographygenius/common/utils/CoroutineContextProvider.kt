package com.appham.geographygenius.common.utils

import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

val coroutineContextModule = module {
    single { CoroutineContextProvider() }
}

open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main}
    open val io: CoroutineContext by lazy { Dispatchers.IO }
}
package com.appham.geographygenius.common.testutils

import com.appham.geographygenius.common.utils.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers

class TestContextProvider : CoroutineContextProvider() {
    override val main = Dispatchers.Unconfined
    override val io = Dispatchers.Unconfined
}
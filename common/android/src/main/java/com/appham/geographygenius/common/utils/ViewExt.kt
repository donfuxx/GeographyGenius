package com.appham.geographygenius.common.utils

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(@StringRes resId: Int, duration: Int = Snackbar.LENGTH_LONG) {
    showSnackbar(context.getString(resId), duration)
}

fun View.showSnackbar(message: CharSequence, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).show()
}
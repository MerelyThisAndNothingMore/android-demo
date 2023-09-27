package com.androiddemo.base.utils

import androidx.annotation.StringRes
import com.androiddemo.base.BaseApplication.Companion.application as app

fun getString(@StringRes stringRes: Int): String {
    return app.getString(stringRes)
}
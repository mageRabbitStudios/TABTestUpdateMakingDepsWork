package com.example.stanislavkinzl.tabtestupdateddep.app

import android.content.Context
import android.util.TypedValue

class Calculator(
    private val context: Context
) {
    internal fun dpToPx(dp: Int) = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics))
}
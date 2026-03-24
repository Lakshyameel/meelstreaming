package com.lagradost.meelstream3.utils

actual fun runOnMainThreadNative(work: () -> Unit) {
    work.invoke()
}
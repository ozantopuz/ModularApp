package com.ozan.core.presentation.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String?.formatDate(): String {
    val currentFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    val date = currentFormat.parse(this)
    return dateFormat.format(date)
}
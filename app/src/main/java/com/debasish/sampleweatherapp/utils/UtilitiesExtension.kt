package com.debasish.sampleweatherapp.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*


fun Context.getDate(
    milliSeconds: Long,
    dateFormat: String?
): String? { // Create a DateFormatter object for displaying date in specified format.
    val formatter = SimpleDateFormat(dateFormat)
    // Create a calendar object that will convert the date and time value in milliseconds to date.
    val calendar: Calendar = Calendar.getInstance()
    calendar.setTimeInMillis(milliSeconds)
    return formatter.format(calendar.getTime())
}
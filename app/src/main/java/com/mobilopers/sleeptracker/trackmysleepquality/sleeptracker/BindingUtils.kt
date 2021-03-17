package com.mobilopers.sleeptracker.trackmysleepquality.sleeptracker

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mobilopers.sleeptracker.R
import com.mobilopers.sleeptracker.trackmysleepquality.convertLongToDateString
import com.mobilopers.sleeptracker.trackmysleepquality.convertNumericQualityToString
import com.mobilopers.sleeptracker.trackmysleepquality.database.SleepNight

/**
 * BindingUtils
 *
 * @author jgonazu
 */

@BindingAdapter("sleepImage")
fun ImageView.setSleepImage(item: SleepNight) {
    setImageResource(
        when (item.sleepQuality) {
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_launcher_sleep_tracker_foreground
        }
    )
}

@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(item: SleepNight?) {
    item?.let {
        text = convertLongToDateString(item.endTimeMilli - item.startTimeMilli)
    }

}

@BindingAdapter("sleepQuality")
fun TextView.setSleepQuality(item: SleepNight?) {
    item?.let {
        text = convertNumericQualityToString(item.sleepQuality, context.resources)
    }
}
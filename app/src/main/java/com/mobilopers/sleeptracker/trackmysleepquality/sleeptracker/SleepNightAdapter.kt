package com.mobilopers.sleeptracker.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobilopers.sleeptracker.R
import com.mobilopers.sleeptracker.databinding.ListItemSleepNightBinding
import com.mobilopers.sleeptracker.trackmysleepquality.convertLongToDateString
import com.mobilopers.sleeptracker.trackmysleepquality.convertNumericQualityToString
import com.mobilopers.sleeptracker.trackmysleepquality.database.SleepNight

/**
 * SleepNightAdapter
 *
 * @author jgonazu
 */
class SleepNightAdapter: ListAdapter<SleepNight, SleepNightAdapter.ViewHolder>(SleepNightDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ListItemSleepNightBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: SleepNight) {
            binding.sleep = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemSleepNightBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class SleepNightDiffCallback: DiffUtil.ItemCallback<SleepNight>() {
        override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
            return oldItem.nightId == newItem.nightId
        }

        override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
            return oldItem == newItem
        }
    }

}


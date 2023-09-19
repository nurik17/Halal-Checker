package sdu.halal.halalchecker.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import sdu.halal.halalchecker.databinding.MainAdditiviesItemBinding

import sdu.halal.halalchecker.presentation.data.Additivies

class AdditiveAdapter : ListAdapter<Additivies, AdditiveAdapter.ViewHolder>(AdditiveDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainAdditiviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position < 5) {
            val item = getItem(position)
            holder.bind(item)
        }
    }

    inner class ViewHolder(private val binding: MainAdditiviesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Additivies) {
            binding.additiviesItem.text = item.name
            binding.additiviesItem.setBackgroundResource(item.backgroundResId)
        }
    }

    private class AdditiveDiffCallback : DiffUtil.ItemCallback<Additivies>() {
        override fun areItemsTheSame(oldItem: Additivies, newItem: Additivies): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Additivies, newItem: Additivies): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemCount(): Int {
        return minOf(super.getItemCount(),5)
    }
}

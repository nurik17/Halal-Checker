package sdu.halal.halalchecker.presentation.home.category

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sdu.halal.halalchecker.databinding.CategoryPageItemBinding
import sdu.halal.halalchecker.presentation.data.ProductCategory

class CategoryPageAdapter : ListAdapter<ProductCategory, CategoryPageAdapter.ViewHolder>(CategoryDiffCallback()) {

      private var itemClickListener: ((ProductCategory) -> Unit)? = null

        fun setItemClickListener(listener :(ProductCategory) -> Unit){
            itemClickListener = listener
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = getItem(position)
            holder.bind(item)
            holder.itemView.setOnClickListener {
                itemClickListener?.invoke(item)
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = CategoryPageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }


        class ViewHolder(private val binding: CategoryPageItemBinding) : RecyclerView.ViewHolder(binding.root) {
            @SuppressLint("SetTextI18n")
            fun bind(item: ProductCategory) {
                binding.textViewTitle.text = item.categoryName
                binding.textViewDescription.text = "${item.numberOfTypes}+ видов"
                Glide.with(binding.imageView)
                    .load(item.imageUrl)
                    .into(binding.imageView)
            }
        }

        private class CategoryDiffCallback : DiffUtil.ItemCallback<ProductCategory>() {
            override fun areItemsTheSame(oldItem: ProductCategory, newItem: ProductCategory): Boolean {
                return oldItem.categoryName == newItem.categoryName
            }

            override fun areContentsTheSame(oldItem: ProductCategory, newItem: ProductCategory): Boolean {
                return oldItem == newItem
            }
        }
    }
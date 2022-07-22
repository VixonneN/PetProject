package ru.khomichenko.myapplication.main_fragment.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.khomichenko.myapplication.databinding.ItemImageBinding
import ru.khomochenko.domain.network.entity.PhotoResponseEntity

class ListImages : ListAdapter<PhotoResponseEntity, ImageViewHolder>(ImagesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ImageViewHolder(
    private val binding: ItemImageBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PhotoResponseEntity) {
        binding.image.load(item.urls.full)
        binding.author.text = item.user.username
    }

}

class ImagesDiffUtil : DiffUtil.ItemCallback<PhotoResponseEntity>() {
    override fun areItemsTheSame(
        oldItem: PhotoResponseEntity,
        newItem: PhotoResponseEntity,
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: PhotoResponseEntity,
        newItem: PhotoResponseEntity,
    ): Boolean {
        return oldItem.id == newItem.id
    }
}
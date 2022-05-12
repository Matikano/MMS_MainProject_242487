package pl.edu.pwr.lab4.i242487.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.edu.pwr.lab4.i242487.databinding.ModuleListItemBinding
import pl.edu.pwr.lab4.i242487.model.Accommodation
import pl.edu.pwr.lab4.i242487.model.ModuleModel
import pl.edu.pwr.lab4.i242487.model.Place

class ModuleRecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<ModuleRecyclerViewAdapter.ModuleViewHolder>() {

    var items: List<ModuleModel> = listOf()

    var onItemClick: ((ModuleModel) -> Unit) ?= null

    inner class ModuleViewHolder(binding: ModuleListItemBinding) : RecyclerView.ViewHolder(binding.root){
        val ivImage = binding.ivImage
        val ivRating = binding.ivRating
        val tvTitle = binding.tvTitleListItem
        val tvRating = binding.tvRating

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val binding: ModuleListItemBinding = ModuleListItemBinding.inflate(
            LayoutInflater.from(context), parent, false)
        return ModuleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val item: ModuleModel = items[position]

        Glide.with(context)
            .load(item.images[0])
            .into(holder.ivImage)

        holder.tvTitle.text = item.name

        when(item){
            is Place -> {
                holder.ivRating.visibility = View.VISIBLE
                holder.tvRating.apply {
                    visibility = View.VISIBLE
                    text = item.rating.toString()
                }
            }
            is Accommodation -> {
                holder.ivRating.visibility = View.VISIBLE
                holder.tvRating.apply {
                    visibility = View.VISIBLE
                    text = item.rating.toString()
                }
            }
            else -> {
                holder.ivRating.visibility = View.GONE
                holder.tvRating.visibility = View.GONE
            }
        }

    }

    override fun getItemCount(): Int = items.size

    fun itemList(list: List<ModuleModel>) {
        items = list
        notifyDataSetChanged()
    }
}
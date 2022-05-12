package pl.edu.pwr.lab4.i242487.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.edu.pwr.lab4.i242487.R
import pl.edu.pwr.lab4.i242487.databinding.PlaceViewPagerItemBinding
import pl.edu.pwr.lab4.i242487.model.Place

class PlacesViewPagerAdapter(private val context: Context) :
    RecyclerView.Adapter<PlacesViewPagerAdapter.PlaceViewHolder>() {

    var places: List<Place> = listOf()

    var onItemClick: ((Place) -> Unit) ?= null

    inner class PlaceViewHolder(binding: PlaceViewPagerItemBinding) : RecyclerView.ViewHolder(binding.root){
        val ivImage = binding.ivImage
        val ivRating = binding.ivRating
        val tvTitle = binding.tvTitleListItem
        val tvRating = binding.tvRating

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(places[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding: PlaceViewPagerItemBinding = PlaceViewPagerItemBinding.inflate(
            LayoutInflater.from(context), parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val place: Place = places[position]

        Glide.with(context)
            .load(place.images[0])
            .into(holder.ivImage)

        holder.tvTitle.text = place.name
        holder.ivRating.apply {
            visibility = View.VISIBLE
            setImageDrawable(context.getDrawable(R.drawable.ic_rating))
        }
        holder.tvRating.apply {
            visibility = View.VISIBLE
            text = place.rating.toString()
        }
    }
    override fun getItemCount(): Int = places.size

    fun placeList(list: List<Place>) {
        places = list
        notifyDataSetChanged()
    }
}
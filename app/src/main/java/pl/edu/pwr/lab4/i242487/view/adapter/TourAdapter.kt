package pl.edu.pwr.lab4.i242487.view.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pl.edu.pwr.lab4.i242487.databinding.TourListItemBinding
import pl.edu.pwr.lab4.i242487.model.TourGuide

class TourAdapter(private val fragment: Fragment) :
    RecyclerView.Adapter<TourAdapter.TourViewHolder>() {

    var tourGuides: List<TourGuide> = listOf()

    var onItemClick: ((TourGuide) -> Unit) ?= null


    inner class TourViewHolder(binding: TourListItemBinding) : RecyclerView.ViewHolder(binding.root){
        var tvName = binding.tvName
        var tvPlacesCount = binding.tvPlacesCount

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(tourGuides[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        return TourViewHolder(
            TourListItemBinding.inflate(fragment.layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val tour = tourGuides[position]

        holder.tvName.text = tour.name
        holder.tvPlacesCount.text = tour.places.size.toString()

    }

    override fun getItemCount(): Int = tourGuides.size

    fun tourList(list: List<TourGuide>){
        tourGuides = list
        notifyDataSetChanged()
    }

}
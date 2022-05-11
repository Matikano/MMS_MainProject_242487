package pl.edu.pwr.lab4.i242487.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.edu.pwr.lab4.i242487.databinding.ViewPagerItemBinding

class ViewPagerAdapter(
    private val activity: AppCompatActivity,
    private val images: List<String>
) : RecyclerView.Adapter<ViewPagerAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(val binding: ViewPagerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ViewPagerItemBinding.inflate(
            LayoutInflater.from(activity), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(activity)
            .load(images[position])
            .into(holder.binding.ivViewPagerImage)
    }

    override fun getItemCount(): Int = images.size

}
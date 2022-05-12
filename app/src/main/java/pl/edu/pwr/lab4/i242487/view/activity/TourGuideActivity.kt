package pl.edu.pwr.lab4.i242487.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import pl.edu.pwr.lab4.i242487.databinding.ActivityTourGuideBinding
import pl.edu.pwr.lab4.i242487.model.Place
import pl.edu.pwr.lab4.i242487.model.TourGuide
import pl.edu.pwr.lab4.i242487.view.adapter.ModuleRecyclerViewAdapter
import pl.edu.pwr.lab4.i242487.view.adapter.PlacesViewPagerAdapter

class TourGuideActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE_KEY_TOUR_GUIDE = "tourGuide"
    }

    private lateinit var tourGuide: TourGuide

    private lateinit var mBinding : ActivityTourGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityTourGuideBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        intent.apply {
            tourGuide = getSerializableExtra(BUNDLE_KEY_TOUR_GUIDE) as TourGuide
        }

        setSupportActionBar(mBinding.toolbarTourGuide)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = tourGuide.name
        }

        mBinding.toolbarTourGuide.setNavigationOnClickListener {
            onBackPressed()
        }

        setupUI()
    }

    private fun setupUI(){

        val placesAdapter = PlacesViewPagerAdapter(applicationContext).apply {
            placeList(tourGuide.places)
            onItemClick = { item ->
                val intent = Intent(applicationContext, PlaceActivity::class.java).apply{
                    putExtra(PlaceActivity.BUNDLE_KEY_PLACE, item)
                }
                startActivity(intent)
            }
        }

        mBinding.apply {
            tvName.text = tourGuide.name
            tvDescription.text = tourGuide.description

            vpPlaces.apply {
//                layoutManager = LinearLayoutManager(applicationContext).apply { orientation = LinearLayoutManager.HORIZONTAL }
                adapter = placesAdapter
            }

            bShowTour.setOnClickListener{
                val intent = Intent(this@TourGuideActivity, MapActivity::class.java).apply {
                    putExtra(MapActivity.BUNDLE_KEY_TOUR_GUIDE, tourGuide)
                    putExtra(MapActivity.BUNDLE_KEY_MODE, MapActivity.MODE_ROUTE)
                }

                startActivity(intent)
            }
        }


    }
}
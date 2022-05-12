package pl.edu.pwr.lab4.i242487.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.edu.pwr.lab4.i242487.databinding.ActivityTourGuideBinding
import pl.edu.pwr.lab4.i242487.model.TourGuide

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
    }
}
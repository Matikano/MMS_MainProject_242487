package pl.edu.pwr.lab4.i242487.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.edu.pwr.lab4.i242487.databinding.ActivityAccommodationBinding
import pl.edu.pwr.lab4.i242487.model.Accommodation
import pl.edu.pwr.lab4.i242487.view.adapter.ImagesViewPagerAdapter
import pl.edu.pwr.lab4.i242487.view.dialog.ReviewDialogFragment

class AccommodationActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE_KEY_ACCOMMODATION = "accommodation"
    }

    private lateinit var mBinding: ActivityAccommodationBinding
    private lateinit var accommodation: Accommodation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAccommodationBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        setSupportActionBar(mBinding.toolbarPlace)

        accommodation = intent.getSerializableExtra(BUNDLE_KEY_ACCOMMODATION) as Accommodation

        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            title = accommodation.name
        }

        setupUI()
    }

    private fun setupUI() {

        val viewPagerAdapter = ImagesViewPagerAdapter(this, accommodation.images)

        mBinding.apply {
            toolbarPlace.setNavigationOnClickListener {
                onBackPressed()
            }

            tvTitle.text = accommodation.name

            tvRating.text = accommodation.rating.toString()

            tvDescription.text = accommodation.description

            vpImages.adapter = viewPagerAdapter
            cpCircleIndicator.setViewPager(vpImages)

            fabMap.setOnClickListener {

                val intent = Intent(this@AccommodationActivity, MapActivity::class.java).apply {
                    putExtra(MapActivity.BUNDLE_KEY_MODEL, accommodation)
                    putExtra(MapActivity.BUNDLE_KEY_MODE, MapActivity.MODE_SINGLE_MARKER)
                }

                startActivity(intent)
            }

            bWriteReview.setOnClickListener {
                ReviewDialogFragment(accommodation.name).apply {
                    show(supportFragmentManager, ReviewDialogFragment.TAG)
                }
            }

        }
    }
}
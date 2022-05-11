package pl.edu.pwr.lab4.i242487.view.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import pl.edu.pwr.lab4.i242487.databinding.ActivityAccommodationBinding
import pl.edu.pwr.lab4.i242487.model.Accommodation
import pl.edu.pwr.lab4.i242487.model.Place
import pl.edu.pwr.lab4.i242487.view.adapter.ViewPagerAdapter
import pl.edu.pwr.lab4.i242487.view.dialog.ReviewDialogFragment
import java.util.*

class AccommodationActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE_KEY_ACCOMMODATION = "accommodation"
    }

    private lateinit var mBinding: ActivityAccommodationBinding

    private lateinit var accommodation: Accommodation

    private lateinit var textToSpeech: TextToSpeech

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

        val viewPagerAdapter = ViewPagerAdapter(this, accommodation.images)

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
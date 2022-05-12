package pl.edu.pwr.lab4.i242487.view.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.MediaController
import pl.edu.pwr.lab4.i242487.databinding.ActivityPlaceBinding
import pl.edu.pwr.lab4.i242487.model.Place
import pl.edu.pwr.lab4.i242487.view.adapter.ViewPagerAdapter
import pl.edu.pwr.lab4.i242487.view.dialog.ReviewDialogFragment
import java.util.*

class PlaceActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE_KEY_PLACE = "place"
    }

    private lateinit var mBinding: ActivityPlaceBinding

    private lateinit var place: Place
    private lateinit var mediaController: MediaController

    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityPlaceBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        setSupportActionBar(mBinding.toolbarPlace)

        place = intent.getSerializableExtra(BUNDLE_KEY_PLACE) as Place

        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            title = place.name
        }

        mediaController = MediaController(this).apply {
            setAnchorView(mBinding.vvVideo)
        }

        setupUI()
    }

    private fun setupUI() {

        val viewPagerAdapter = ViewPagerAdapter(this, place.images)

        mBinding.apply {
            toolbarPlace.setNavigationOnClickListener {
                onBackPressed()
            }

            tvTitle.text = place.name

            tvRating.text = place.rating.toString()

            tvDescription.text = place.description

            vpImages.adapter = viewPagerAdapter
            cpCircleIndicator.setViewPager(vpImages)

            fabMap.setOnClickListener {

                val intent = Intent(this@PlaceActivity, MapActivity::class.java).apply {
                    putExtra(MapActivity.BUNDLE_KEY_MODEL, place)
                    putExtra(MapActivity.BUNDLE_KEY_MODE, MapActivity.MODE_SINGLE_MARKER)
                }

                startActivity(intent)
            }

            bWriteReview.setOnClickListener {
                ReviewDialogFragment(place.name).apply {
                    show(supportFragmentManager, ReviewDialogFragment.TAG)
                }
            }

            ivVoiceAssistant.setOnClickListener {
                textToSpeech = TextToSpeech(
                    applicationContext
                ) {
                    if (it == TextToSpeech.SUCCESS) {
                        textToSpeech.language = Locale.US
                        textToSpeech.speak(place.description, TextToSpeech.QUEUE_FLUSH,null,null)
                    }
                }
            }

            vvVideo.apply {
                val videoUri = Uri.parse("android.resource://$packageName/${place.video}")

                setMediaController(mediaController)
                setVideoURI(videoUri)
                seekTo(1)
                setOnCompletionListener {
                    seekTo(1)
                }
            }
        }
    }
}
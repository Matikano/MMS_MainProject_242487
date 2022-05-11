package pl.edu.pwr.lab4.i242487.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.edu.pwr.lab4.i242487.databinding.ActivityAccommodationBinding
import pl.edu.pwr.lab4.i242487.databinding.ActivityEventBinding
import pl.edu.pwr.lab4.i242487.model.Accommodation
import pl.edu.pwr.lab4.i242487.model.Event
import pl.edu.pwr.lab4.i242487.view.adapter.ViewPagerAdapter
import pl.edu.pwr.lab4.i242487.view.dialog.ReviewDialogFragment

class EventActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE_KEY_EVENT = "event"
    }

    private lateinit var mBinding: ActivityEventBinding

    private lateinit var event: Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        setSupportActionBar(mBinding.toolbarPlace)

        event = intent.getSerializableExtra(BUNDLE_KEY_EVENT) as Event

        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            title = event.name
        }

        setupUI()
    }

    private fun setupUI() {

        val viewPagerAdapter = ViewPagerAdapter(this, event.images)

        mBinding.apply {
            toolbarPlace.setNavigationOnClickListener {
                onBackPressed()
            }

            tvTitle.text = event.name

            tvDescription.text = event.description

            vpImages.adapter = viewPagerAdapter
            cpCircleIndicator.setViewPager(vpImages)

            fabMap.setOnClickListener {

                val intent = Intent(this@EventActivity, MapActivity::class.java).apply {
                    putExtra(MapActivity.BUNDLE_KEY_MODEL, event)
                }

                startActivity(intent)
            }

        }
    }
}
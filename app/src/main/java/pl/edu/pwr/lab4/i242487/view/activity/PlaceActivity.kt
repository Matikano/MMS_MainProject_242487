package pl.edu.pwr.lab4.i242487.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.edu.pwr.lab4.i242487.R
import pl.edu.pwr.lab4.i242487.databinding.ActivityPlaceBinding

class PlaceActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityPlaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityPlaceBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setSupportActionBar(mBinding.toolbarPlace)

        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "PlaceTitle"
        }

        mBinding.toolbarPlace.setNavigationOnClickListener {
            onBackPressed()
        }

    }
}
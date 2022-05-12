package pl.edu.pwr.lab4.i242487.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import pl.edu.pwr.lab4.i242487.R
import pl.edu.pwr.lab4.i242487.databinding.ActivityMapBinding
import pl.edu.pwr.lab4.i242487.model.ModuleModel
import pl.edu.pwr.lab4.i242487.model.TourGuide

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object{
        const val BUNDLE_KEY_MODEL = "model"
        const val BUNDLE_KEY_TOUR = "tour"
        const val BUNDLE_KEY_MODE = "mode"

        const val MODE_SINGLE_MARKER = "single_marker"
        const val MODE_ROUTE = "route"

        const val ZOOM_FACTOR = 14.5f
    }

    private lateinit var mBinding: ActivityMapBinding

    private lateinit var moduleModel: ModuleModel
    private lateinit var tourGuide: TourGuide

    private var mode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        intent.apply {
            mode = getStringExtra(BUNDLE_KEY_MODE)
            when(mode){
                MODE_SINGLE_MARKER ->
                    moduleModel = getSerializableExtra(BUNDLE_KEY_MODEL) as ModuleModel

                MODE_ROUTE ->
                    tourGuide = getSerializableExtra(BUNDLE_KEY_TOUR) as TourGuide
            }
        }

        setSupportActionBar(mBinding.toolbarMap)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = moduleModel.name
        }

        mBinding.toolbarMap.setNavigationOnClickListener {
            onBackPressed()
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        when(mode){
            MODE_SINGLE_MARKER ->{
                val position = LatLng(
                    moduleModel.latLong.first,
                    moduleModel.latLong.second
                )

                googleMap.addMarker(MarkerOptions().position(position).title(moduleModel.address))

                val newLatLngZoomed = CameraUpdateFactory.newLatLngZoom(position, ZOOM_FACTOR)
                googleMap.animateCamera(newLatLngZoomed)
            }
            MODE_ROUTE ->{
                //TODO: implement showing route direction functionality
            }

        }
    }
}
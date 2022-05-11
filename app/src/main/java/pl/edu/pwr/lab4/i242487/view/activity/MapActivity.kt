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

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object{
        const val BUNDLE_KEY_MODEL = "model"
        const val ZOOM_FACTOR = 13f
    }

    private lateinit var mMap: GoogleMap
    private lateinit var mBinding: ActivityMapBinding

    private lateinit var moduleModel: ModuleModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        moduleModel = intent.getSerializableExtra(BUNDLE_KEY_MODEL) as ModuleModel


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
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        val position = LatLng(
            moduleModel.latLong.first,
            moduleModel.latLong.second
        )

        googleMap.addMarker(MarkerOptions().position(position).title(moduleModel.address))

        val newLatLngZoomed = CameraUpdateFactory.newLatLngZoom(position, ZOOM_FACTOR)
        googleMap.animateCamera(newLatLngZoomed)
    }
}
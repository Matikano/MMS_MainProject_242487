package pl.edu.pwr.lab4.i242487.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import pl.edu.pwr.lab4.i242487.BuildConfig.MAPS_API_KEY
import pl.edu.pwr.lab4.i242487.R
import pl.edu.pwr.lab4.i242487.databinding.ActivityMapBinding
import pl.edu.pwr.lab4.i242487.model.ModuleModel
import pl.edu.pwr.lab4.i242487.model.Place
import pl.edu.pwr.lab4.i242487.model.TourGuide
import pl.edu.pwr.lab4.i242487.utils.apiDirections.JsonParser
import pl.edu.pwr.lab4.i242487.utils.apiDirections.Parser

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object{
        const val BUNDLE_KEY_MODEL = "model"
        const val BUNDLE_KEY_TOUR_GUIDE = "tourGuide"
        const val BUNDLE_KEY_MODE = "mode"

        const val MODE_SINGLE_MARKER = "single_marker"
        const val MODE_ROUTE = "route"

        const val ZOOM_FACTOR = 14.5f
        const val ROUTE_ZOOM_FACTOR = 12.5f
    }

    private lateinit var mBinding: ActivityMapBinding

    private lateinit var moduleModel: ModuleModel
    private lateinit var tourGuide: TourGuide

    private var pathLine: PolylineOptions? = null

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
                    tourGuide = getSerializableExtra(BUNDLE_KEY_TOUR_GUIDE) as TourGuide
            }
        }

        setSupportActionBar(mBinding.toolbarMap)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            when(mode){

                MODE_SINGLE_MARKER ->
                   title = moduleModel.name

                MODE_ROUTE ->
                    title = tourGuide.name
            }
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
                val start = tourGuide.places.first().latLng()
                val placesLatLng = mutableListOf<LatLng>()
                for (place: Place in tourGuide.places){
                    val latLng = place.latLng()
                    googleMap.addMarker(
                        MarkerOptions()
                            .position(latLng)
                            .title(place.address)
                    )
                    placesLatLng.add(latLng)
                }

                drawPath(googleMap, placesLatLng)

                googleMap.apply {
                    animateCamera(CameraUpdateFactory.newLatLngZoom(start, ROUTE_ZOOM_FACTOR))
                }
            }

        }
    }

    fun drawPath(googleMap:GoogleMap, points: List<LatLng>) {
        var parser: Parser
        val jsonURL = "https://maps.google.com/maps/api/directions/json?"

        val start = points.first()
        val dest = points.last()

        val sBuf = StringBuffer(jsonURL)
            .append("origin=")
            .append(start.latitude)
            .append(',')
            .append(start.longitude)
            .append("&destination=")
            .append(dest.latitude)
            .append(',')
            .append(dest.longitude)

        if(points.size > 2){
            sBuf.append("&waypoints=optimize:true")
            for (i in 1 until points.size - 1){
                val point = points[i]
                sBuf.append('|')
                    .append(point.latitude)
                    .append(',')
                    .append(point.longitude)
            }
        }

        sBuf.append("&sensor=true&mode=walking")
        sBuf.append("&key=${MAPS_API_KEY}")

        val URL = sBuf.toString()

        val request = object: StringRequest(
            Method.GET,
            URL,
            {
                response ->
                parser = JsonParser(URL)
                val route = parser.parse(response)
                val routePoints = route.points

                if(pathLine != null)
                    pathLine = null

                pathLine = PolylineOptions().apply {
                    addAll(routePoints!!)
                    color(resources.getColor(R.color.routecolor, null))
                }

                googleMap.apply {
                    addPolyline(pathLine!!)
                }
            },
            {
                Log.e("VolleyError","Message: ${it.message}")
            }
        ){}

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(request)
    }
}
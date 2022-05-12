package pl.edu.pwr.lab4.i242487.utils

import com.google.android.gms.maps.model.LatLng

val Pair<Double, Double>.latLng: LatLng
    get() { return LatLng(this.first, this.second)}

class Utils {

}
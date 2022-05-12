package pl.edu.pwr.lab4.i242487.utils

import com.google.android.gms.maps.model.LatLng


class Utils {

    companion object {
        fun latLng(pair: Pair<Double, Double>): LatLng = LatLng(pair.first, pair.second)
    }
}

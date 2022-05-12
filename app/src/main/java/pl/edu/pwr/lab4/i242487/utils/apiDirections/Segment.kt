package pl.edu.pwr.lab4.i242487.utils.apiDirections

import com.google.android.gms.maps.model.LatLng

data class Segment(
    var start: LatLng?,
    var instruction: String?,
    var length: Int?,
    var distance: Double?
){
    constructor(): this(null, null, null, null){}

    fun copy(): Segment {
        return Segment().also {
            it.start = start
            it.instruction = instruction
            it.length = length
            it.distance = distance
        }
    }
}

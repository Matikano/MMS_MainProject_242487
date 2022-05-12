package pl.edu.pwr.lab4.i242487.utils.apiDirections

import com.google.android.gms.maps.model.LatLng

data class Route(
    var name: String?,
    var points: MutableList<LatLng>?,
    var segments: MutableList<Segment>?,
    var copyright: String?,
    var warning: String?,
    var country: String?,
    var length: Int?,
    var polyline: String?
){
    constructor() : this(null, null, null, null, null, null, null, null)

    init {
        points = mutableListOf()
        segments = mutableListOf()
    }

    fun addPoints(points: List<LatLng>){
        this.points!!.addAll(points)
    }

    fun addSegment(segment: Segment){
        segments!!.add(segment)
    }
}

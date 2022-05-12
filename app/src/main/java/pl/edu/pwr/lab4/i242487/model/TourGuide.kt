package pl.edu.pwr.lab4.i242487.model

import java.io.Serializable

data class TourGuide(
    val name: String,
    val description: String,
    val places: List<Place>
) : Serializable

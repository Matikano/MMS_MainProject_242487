package pl.edu.pwr.lab4.i242487.model

data class Place(
    val name: String,
    val description: String,
    val address: String,
    val latLong: Pair<Double, Double>,
    val rating: Double,
    val reviews: List<Review>,
    val images: List<String>,
    val video: String
)

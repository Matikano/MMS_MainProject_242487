package pl.edu.pwr.lab4.i242487.model

data class Accommodation(
    val name: String,
    val description: String,
    val latLong: Pair<Double, Double>,
    val rating: Double,
    val reviews: List<Review>,
    val images: List<String>,
)

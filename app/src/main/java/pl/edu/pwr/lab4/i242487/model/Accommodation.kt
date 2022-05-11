package pl.edu.pwr.lab4.i242487.model

class Accommodation(
    name: String,
    description: String,
    address: String,
    latLong: Pair<Double, Double>,
    val rating: Double,
    images: List<String>,
) : ModuleModel(name, description, address, latLong, images)

package pl.edu.pwr.lab4.i242487.model

import android.os.Parcel
import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import pl.edu.pwr.lab4.i242487.utils.Utils


class Place(
    name: String,
    description: String,
    address: String,
    latLong: Pair<Double, Double>,
    val rating: Double,
    images: List<String>,
    val video: Int
) : ModuleModel(name, description, address, latLong, images){

    fun latLng(): LatLng = Utils.latLng(latLong)

}

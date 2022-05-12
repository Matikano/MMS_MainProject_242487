package pl.edu.pwr.lab4.i242487.utils.apiDirections


import com.google.android.gms.maps.model.LatLng
import org.json.JSONException
import org.json.JSONObject

class JsonParser(url: String): XMLParser(url), Parser {

    private var distance = 0

    override fun parse(result: String): Route {
        val route = Route()
        val segment = Segment()
        var routeLength = 0

        try{
            val json = JSONObject(result)

            val jsonRoute = json.getJSONArray("routes").getJSONObject(0)

            val legs = jsonRoute.getJSONArray("legs")

            route.copyright += jsonRoute.getString("copyrights")

            for (i in 0 until legs.length()){
                val leg = legs.getJSONObject(i)
                val steps = leg.getJSONArray("steps")
                val numSteps = steps.length()


                routeLength += leg.getJSONObject("distance").getInt("value")

                if(!jsonRoute.getJSONArray("warnings").isNull(i))
                    route.warning += jsonRoute.getJSONArray("warnings").getString(i)

                for (j in 0 until numSteps){
                    val step = steps.getJSONObject(j)
                    val start = step.getJSONObject("start_location")
                    val  position = LatLng(
                        start.getDouble("lat"),
                        start.getDouble("lng")
                    )

                    val length = step.getJSONObject("distance").getInt("value")
                    distance += length
                    segment.let {
                        it.start = position
                        it.length = length
                        it.distance = (this.distance / 1000).toDouble()
                        it.instruction = step.getString("html_instructions").replace("<(.*?)*>", "")
                    }

                    route.apply {
                        addPoints(decodePolyLine(step.getJSONObject("polyline").getString("points")))
                        addSegment(segment.copy())
                    }
                }
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        return route
    }

    private fun decodePolyLine(poly: String): List<LatLng> = PolyLineDecoder.decodePolyLine(poly)

}
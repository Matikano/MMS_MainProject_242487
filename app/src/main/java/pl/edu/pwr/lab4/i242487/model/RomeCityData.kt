package pl.edu.pwr.lab4.i242487.model

object RomeCityData {

    fun places(): List<Place>  =
        listOf(
            Place(
                "Colosseum",
                "Monumental 3-tiered Roman amphitheater once used for gladiatorial games, with guided tour option",
                "Piazza del Colosseo, 1, 00184 Roma RM, Italy",
                Pair(41.890242147274165, 12.492198713138903),
                4.7,
                listOf(
                    Review(
                        "Adrian Murillo",
                        null,
                        4
                    ),
                    Review(
                        "Mellisa Martins",
                        "Visited on\n" +
                                "Weekday\n" +
                                "Wait time\n" +
                                "No wait\n" +
                                "Reservation recommended\n" +
                                "Yes",
                        5
                    ),
                    Review(
                        "mark waterhouse",
                        "One of the wonders of the world",
                        5
                    ),
                    Review(
                        "Sabrina Surbone",
                        null,
                        5
                    ),
                    Review(
                        "Hala G",
                        "Amazing and impressive",
                        5
                    )
                ),
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipPX04NmKh7_4Q6r4_hlrm4Max9fDK247-AgFSBf=s482-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipOxqSOsONWBOE8QT9TjV9CXOAjaiNl6FK4QDLwJ=s443-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipP2ITSyd55OZAzU-T35XTatMLefsrD91JrBwCbo=s445-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipPpD7jdASjSS1ew-GTxebMOp4bfMLJSYfuTRKjc=s464-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipOA6J56z2EY1yX3Nj4mH3MPqGCyhH1NM9VdwWmQ=s490-k-no"
                ),
                ""
            )
        )

}
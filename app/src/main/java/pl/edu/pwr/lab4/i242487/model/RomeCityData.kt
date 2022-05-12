package pl.edu.pwr.lab4.i242487.model

import pl.edu.pwr.lab4.i242487.R

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
                    "https://lh5.googleusercontent.com/p/AF1QipPX04NmKh7_4Q6r4_hlrm4Max9fDK247-AgFSBf=s482-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipOxqSOsONWBOE8QT9TjV9CXOAjaiNl6FK4QDLwJ=s443-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipP2ITSyd55OZAzU-T35XTatMLefsrD91JrBwCbo=s445-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipPpD7jdASjSS1ew-GTxebMOp4bfMLJSYfuTRKjc=s464-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipOA6J56z2EY1yX3Nj4mH3MPqGCyhH1NM9VdwWmQ=s490-k-no"
                ),
                R.raw.colosseum
            ),
            Place(
                "Basilica Papale di Santa Maria Maggiore",
                "Landmark papal basilica founded in the 5th century & known for its Roman mosaics & gilded ceiling",
                "P.za di Santa Maria Maggiore, 00100 Roma RM, Italy",
                Pair(41.8981895536215, 12.49858006065195),
                4.8,
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipOTmfefQdLT8TKf6XCA2qoK-7z13VVOat4vnCpQ=s387-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipP1BWZscC4urdVpa4SV7FOTfDvB_6AJqBvGE8Ih=s435-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipPwECZTQt80149ODRg0pc6JPbMJDUWm0IpO9iU=s388-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipM4qZh4ogDKuO_Tjh6EONY-D858mc-sXDTgYio3=s387-k-no"
                ),
                R.raw.basilica_papale_di_santa_maria_maggorie
            ),
            Place(
                "Trevi Fountain",
                "Aqueduct-fed rococo fountain, designed by Nicola Salvi & completed in 1762, with sculpted figures",
                "Piazza di Trevi, 00187 Roma RM, Italy",
                Pair(41.90166715991423, 12.483398830627646),
                4.7,
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipPm51-LLz1Sb4CpbHO2f9-x0gil_DawtjYzyazC=s466-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipPPbRoz-lbU6-POwi3UqbFFtDf8XscLBIiI13lj=s387-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipMyACZ2uUWKvHploXJtiVaSZ2rNzXGGHa3-ksa-=s435-k-no"
                ),
                R.raw.trevi_fountain
            ),
            Place(
                "Pantheon",
                "Iconic temple built circa 118 to 125 A.D. with a dome & Renaissance tombs, including Raphael's",
                "Piazza della Rotonda, 00186 Roma RM, Italy",
                Pair(41.89908994440991, 12.476701238563988),
                4.8,
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipNq6CDa-SYbgCt6loiuef6JimdSAi-sdCuQ-FVJ=s403-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipOABXTxpN0BwOyGP9wkzr6rfBiuCAWp7KzRJsoh=s381-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipNxu-19r-MEoFFpUuYVwThpD_axj8w5ZivFuKyk=s406-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipODusMHOem3IxFbQaUz1WDgx5El1eBGg1NPWAoL=s435-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipNTIeMtvzH1c_caqK-zUPeZzyPBmte8BsafBfsg=s453-k-no"
                ),
                R.raw.pantheon
            ),
            Place(
                "Castel Sant'Angelo",
                "Circular, 2nd-century castle housing furniture & paintings collections in Renaissance apartments",
                "Lungotevere Castello, 50, 00193 Roma RM, Italy",
                Pair(41.903510370380324, 12.466147253907929),
                4.7,
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipPhFcZZNwMF4vhsS7bj92wNkR1Y8lQbphCApTQK=s479-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipM1D2ItXbIQCY_RWYVQ41C7eEqqdtvnDhBUBz8B=s438-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipOafaFgnZQbJfsVTPrBE9VCauBVwm1HJpHzSpXT=s387-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipOxLPE0_dQ6t1qm9tvZ8M-_znYkzl_37277zYn-=s464-k-no"
                ),
                R.raw.castel_sant_angelo
            )
        )


    fun accommodations(): List<Accommodation> =
        listOf(
            Accommodation(
                "Palazzo Navona Hotel",
                "A 4-minute walk from the Pantheon, this upscale hotel is 9 minutes on foot from the Spanish Steps and 2 km from the nearest metro station.\n" +
                        "Chic, modern rooms come with free Wi-Fi and flat-screen TVs, as well as minibars, and tea and coffeemaking facilities; some have balconies offering city views. Upgraded rooms add separate living areas with daybeds.\n" +
                        "A breakfast buffet (surcharge) is served in a refined dining room. There's also a swanky rooftop bar offering city views and a lounge",
                "Largo della Sapienza, 8, 00186 Roma RM, Italy",
                Pair(41.89814411907259, 12.474537203087323),
                4.4,
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipOuBDWexTq2j5nr6TPdH9HYcGUr-wk82UGRQOLT=s435-k-no",
                    "https://lh6.googleusercontent.com/proxy/p-Uah1Q_I-To57_T0qR134oKvmiaTLEeMl5Huxl_Hh4xUQRPRDO2-AeKk-_1PjqSeJunIlq-_VpdHTysc72Ge03ac8fCcbM_89cYpoYNcGLtdDbFZS2YfnBt2pzABCIRKKcJvybiDNc6191vmATU2utdK4WjVx0=s435-k-no",
                    "https://lh4.googleusercontent.com/proxy/eIBa1i11KhIeey1kDDh3EeIHWz5oVPcoUtds3l4DjcMrJNJLg8h9aoq4YU5UXKT2BTxkT3_JoCBnFF97_WLs61p6SYKRxFMtIGRE1oNnA0yeen2CHOtObMc-shUsBGx2QfrS0k9gjzeY0EvPR5ttZ8mApD3kmg=s436-k-no"
                )
            ),
            Accommodation(
                "Trevi Palace Luxury Inn",
                "A 1-minute walk from the Trevi Fountain, this upscale hotel in a 17th-century Roman palace is a 6-minute walk from Barberini metro station and 13 minutes away on foot from Piazza Navona, a 1st-century public square.\n" +
                        "Polished suites come with Wi-Fi, flat-screen TVs, minibars and coffeemakers. Some have kitchenettes, city views, exposed beam ceilings and/or terraces. Butler service is available.\n" +
                        "Amenities include a fitness room, a sauna and a steam room. Massages are offered for a fee. Breakfast is available.",
                "Via del Lavatore, 30, 00187 Roma RM, Italy",
                Pair(41.90143355407556, 12.484677137555893),
                4.2,
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipNLSWBtK-LhXg_7ziLoonvN2TwgIO8KMkZit0-s=s499-k-no",
                    "https://lh5.googleusercontent.com/proxy/aIndVzKk1I-jS7TGP-bNh5XM1JKYtWOgsEXImWnOtQHHTBdQRurZmBZZfg8-PAJV5kmC99E8csBz4Fww9Ag3bTf4telNvyly1m6JYis0WAO36S4pgk2g2AlwkssYFcFZU5maJE7UzMfuCR9lqimybZzer7FewXU=s436-k-no",
                    "https://lh5.googleusercontent.com/proxy/OYJhE1afZsfjRtqleDzkeaEFqeRFVzmyZupvCF781i7hfoR95NTs110OlX0khIjVwa04da-tBE9lRnuzOieh1MjunN6xTh83kxwh6AdxZK9MC_3Oq8EPoEj13PSxoDJCnyvgCSMbsUZfyIY7qoC42ABkcLcJ6Q=s435-k-no"
                )
            ),
            Accommodation(
                "J.K. Place Roma",
                "Set near the Tiber River, this opulent hotel decorated with sculptures and art is a 9-minute walk from the iconic Pantheon, a 10-minute walk from Piazza Navona and 18 km from Rome Ciampino Airport (CIA).\n" +
                        "Sophisticated rooms and suites, some with 4-poster canopy beds, come with marble bathrooms, Wi-Fi and flat-screen TVs. All also include iPod docks and minibars. Suites add sitting or living areas; some have sofabeds. Room service is available.\n" +
                        "An upscale restaurant/bar features dark wood floors and a stylish, cosmopolitan vibe. There's also an elegant cafe/bar, and guest lounges.",
                "Via di Monte d'Oro, 30, 00186 Roma RM, Italy",
                Pair(41.90470342755597, 12.47688866467187),
                4.7,
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipOEQb9ogoXrMulmILl4JpZw1ZSGp-wCdaimrnZy=s459-k-no",
                    "https://lh3.googleusercontent.com/proxy/vzq25G45Rv25zsI0HaM6TM68AQHLBnB3nXI20yU3DyUq1TFroQq1aZwPaWy0xTIh3oDC3V4tnACKDjKlWoVxtnb-kZBQCFB3DgVWF6qPonlX_EY1S0RQTUFp0PwU821oEgeasJRB6M4-BwouQY4CpxcN4ysRNIk=s440-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipOl69CuzxQsdQFaSb3-NSHFWYgQJbFqb53gQQz1=s461-k-no"
                )
            )
        )

    fun events(): List<Event> =
        listOf(
            Event(
                "Colosseum show",
                "A theatrical performance that takes places in the famous ancient Colosseum amphitheater. The actors will perform a number of acts taken from ancient Rome culture.",
                "Piazza del Colosseo, 1, 00184 Roma RM, Italy",
                Pair(41.89042582301495, 12.49218798278093),
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipPBs_2HwxmYsTJ_As8nDfjVYCCYhJB4CNL_YOGh=s580-k-no-pi-6.84803-ya338.34146-ro0-fo100",
                    "https://lh5.googleusercontent.com/p/AF1QipMT_Yb06k_KLe6f45ETrlf4Odb_jN7wLXrr1Lpx=s435-k-no"
                )
            ),
            Event(
                "Free Pantheon Tour Guide",
                "One and only chance to get a free guide around famous Pantheon building by one of the local guides. Duration not longer than 1 hour. Interesting and thrilling history. Guaranteed satisfaction!",
                "Piazza della Rotonda, 00186 Roma RM, Italy",
                Pair(41.89925463391922, 12.476813562729733),
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipPmbZkR53xsqgcwvq-69jJZNdjr0sL7SJBx9FJq=s435-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipMXHQdad-TTNqJ6Uf4zfjEDRDqAnFccAMlEmK4H=s387-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipODusMHOem3IxFbQaUz1WDgx5El1eBGg1NPWAoL=s435-k-no"
                )
            ),
            Event(
                "St. Angelo Bridge Royal Guard March",
                "Join us in the magnificent show of Italian Royal Guard march down the St. Angelo Bridge. There will  be about 200 soldiers dressed us Italian Royal Guard performing an old military show of culture. ",
                "Ponte Sant'Angelo, 00186 Roma RM, Italy",
                Pair(41.902587589774285, 12.466573217208934),
                listOf(
                    "https://lh5.googleusercontent.com/p/AF1QipNXeEvgnsijD9DgFEAaNBRcIOUOftGweyCdHgrB=s483-k-no",
                    "https://lh5.googleusercontent.com/p/AF1QipNGiJslQsKbpW8com39iF8f7y2_AvaxJUTZRrgp=s387-k-no"
                )
            )
        )

    fun tours(): List<TourGuide> {
        val places = places()

        return listOf(
            TourGuide(
                "Rome full antique guide",
                "Discover the most interesting and breathtaking antiques of Rome! You will get a professional tour guide around most famous Ancient Roman architecture." +
                        "\nYou will experience unforgettable while exploring buildings like Colosseo, Basilica Papale di Santa Maria Maggiore, Pantheon, Fontanna di Trevi and Castel Sant'Angelo. ",
                places
            ),
            TourGuide(
                "Senior pilgrimage tour",
                "Take a part in our newest Senior Tour. It is a short route starting with exploring and touring Basilica Papale di Santa Maria Maggiore with an unique opportunity in participating in the holy mass." +
                        "\nAfter that join us in a easy walk to the Trevi Fountain where you can rest in peace.",
                listOf(places[1], places[2])
            ),
            TourGuide(
                "In the footsteps of the legionnaires",
                "Join us in a very thrilling and exciting tour around places once guarded by Roman Legionnaires." +
                        "\n This tour is especially dedicated for children, since our Tour Guide is dressed as one of the Ancient Roman Soldiers." +
                        "\n You will discover a magnificent places such as Colosseum, Pantheon and Castel Sant'Angelo",
                listOf(places[0], places[3], places[4])
            )
        )
    }

}
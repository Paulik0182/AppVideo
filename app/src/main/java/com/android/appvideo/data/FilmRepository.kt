package com.android.appvideo.data

import com.android.appvideo.R

class FilmRepository {
    companion object {
        val filmConstructor: ArrayList<FilmConstructor> = arrayListOf(
            FilmConstructor(
                0,
                "ЛЮПЕН",
                "2021, преступление, детектив, драма, боевик",
                R.drawable.lupin,
                true
            ),
            FilmConstructor(
                1,
                "ЛЮЦИФЕР",
                "2020, фэнтези, драма, преступление",
                R.drawable.lucifer,
                true
            ),
            FilmConstructor(
                2,
                "РАГНАРЁК",
                "2021, боевик, фэнтези, детектив, драма",
                R.drawable.ragnarok,
                            ),
            FilmConstructor(
                3,
                "БУМАЖНЫЙ ДОМ",
                "2020, боевик, триллер, преступление, детектив",
                R.drawable.la_casa_de_papel,
                            ),
            FilmConstructor(
                4,
                "НЕСПЯЩИЕ",
                "2021, фантастика, драма, боевик, триллер, приключения",
                R.drawable.sleepless
            ),
            FilmConstructor(
                5,
                "ВОЛШЕБНЫЙ ДРАКОН",
                "2021, мультфильм, фэнтези, комедия, приключения, семейный",
                R.drawable.wish_dragon
            )
        )
    }
}
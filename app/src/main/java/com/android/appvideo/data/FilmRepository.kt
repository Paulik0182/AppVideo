package com.android.appvideo.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.recyclerview.widget.ListUpdateCallback
import com.android.appvideo.R

@SuppressLint("ParcelCreator")
data class FilmRepository(
    val id: Int,
    val name: String,
    val description: String,
    val descriptionDetail: String,
    val imageID: Int,
    var isFavorite: Boolean = false
)

fun getRussianCities() = listOf(
    FilmRepository(0,
        "ЛЮПЕН",
        "2021, преступление, детектив, драма, боевик",
        "Дата выхода: 8 января 2021 г." +
                "\nСтраны: Франция, США" +
                "\nСенегальский иммигрант Ассан Диоп планирует похитить выставленное на аукцион в " +
                "Лувре колье Марии-Антуанетты. 25 лет назад за кражу у богатого семейства именно этой " +
                "драгоценности был несправедливо осуждён его отец, поэтому Ассаном движет месть. " +
                "Ещё подростком парень зачитывался приключениями джентльмена-грабителя Арсена Люпена и " +
                "теперь будет действовать в лучших традициях своего книжного кумира.",
        R.drawable.lupin,
        true),
    FilmRepository(1,
        "ЛЮЦИФЕР",
        "2020, фэнтези, драма, преступление",
        "Страна: США " +
                "\nДата выхода: 22 февраля 2016 г." +
                "\nЗаскучавший и несчастный повелитель преисподней Люцифер Морнингстар оставил свой престол и " +
                "отправился в современный Лос-Анджелес, где основал ночной клуб «Lux». Очаровательный, " +
                "харизматичный и дьявольски привлекательный Люцифер наслаждается отдыхом — вином, женщинами и " +
                "музыкой, пока красивая поп-звезда не оказывается убитой на пороге его клуба.",
        R.drawable.lucifer,
        true),
    FilmRepository(2,
        "РАГНАРЁК",
        "2021, боевик, фэнтези, детектив, драма",
        "Страны: Норвегия, Дания" +
                "\nВ крошечный норвежский городок Эдда возвращаются с матерью сыновья-подростки Магне и " +
                "Лориц. Их семья покинула Эдду много лет назад после гибели отца мальчишек, а теперь мать нашла " +
                "тут работу: она устраивается бухгалтером на завод местных богачей Ютулов. Ютулы верховодят в " +
                "Эдде повсюду: красавцы Фьор и Сакса — самые популярные подростки в школе, а их мать в этой " +
                "школе директор. Их завод производит химикаты, и одноклассница Магне подозревает, что Ютулы " +
                "каким-то образом загадили ртутью местный фьорд. Магне втягивается в её праведную борьбу и " +
                "вскоре обнаруживает у себя суперспособность: он может метнуть молот больше чем на 500 метров.",
        R.drawable.ragnarok,),
    FilmRepository(3,
        "БУМАЖНЫЙ ДОМ",
        "2020, боевик, триллер, преступление, детектив",
        "Страна: Испания" +
                "\nВосемь воров берут заложников и запираются в Королевском монетном дворе Испании, " +
                "пока криминальный авторитет манипулирует полицией, чтобы реализовать свой план.",
        R.drawable.la_casa_de_papel,),
    FilmRepository(4,
        "НЕСПЯЩИЕ",
        "2021, фантастика, драма, боевик, триллер, приключения",
        "Страна: США" +
                "\nДата выхода: 2021 г. (мир)" +
                "\nВ результате глобальной катастрофы перестают работать электронные приборы и люди теряют " +
                "способность спать. Мир погружается в хаос. Только у Джилл, бывшей военнослужащей с непростым " +
                "прошлым, возможно, есть ключ к спасению — ее собственная дочь.",
        R.drawable.sleepless),
    FilmRepository(
        5,
        "ВОЛШЕБНЫЙ ДРАКОН",
        "2021, мультфильм, фэнтези, комедия, приключения, семейный",
        "Страны: Китай, США, Гонконг" +
                "\nДата выхода: 2021 г. (мир)" +
                "\nОбычный парень случайно высвобождает из чайника розового дракона, исполняющего желания. " +
                "Дракон много веков просидел в заточении, и теперь ему ужасно интересно, как за это время изменился мир.",
        R.drawable.wish_dragon,
    )
)

fun getWorldCities() = listOf(
    FilmRepository(0,
        "LUPIN",
        "2021, crime, detective, drama, action",
        "Release date: January 8, 2021" +
                "\nCountries: France, USA" +
                "\nSenegalese immigrant Assan Diop plans to steal a Marie Antoinette necklace put up for " +
                "auction at the Louvre. 25 years ago, his father was unjustly convicted of stealing this " +
                "particular jewel from a rich family, so Assan is driven by revenge. As a teenager, the guy " +
                "was reading the adventures of the gentleman robber Arsene Lupin and now he will act in the " +
                "best traditions of his book idol.",
        R.drawable.lupin,
        true),
    FilmRepository(1,
        "LUCIFER",
        "2020, fantasy, drama, crime",
        "Country: USA " +
                "\nRelease date: February 22, 2016" +
                "\nThe bored and unhappy lord of the underworld, Lucifer Morningstar, left his throne and " +
                "went to modern Los Angeles, where he founded the Lux nightclub. Charming, charismatic and " +
                "devilishly attractive Lucifer enjoys a vacation — wine, women and music, until a beautiful " +
                "pop star is killed on the doorstep of his club.",
        R.drawable.lucifer,
        true),
    FilmRepository(2,
        "RAGNAROK",
        "2021, action, fantasy, detective, drama",
        "Countries: Norway, Denmark" +
                "\nThe teenage sons Magne and Loritz return to the tiny Norwegian town of Edda with their mother. " +
                "Their family left Edda many years ago after the death of the boys ' father, and now their mother " +
                "has found a job here: she gets a job as an accountant at the factory of the local rich Yutuls. " +
                "The Jutuls rule everywhere in Edda: the handsome Fjor and Saksa are the most popular teenagers " +
                "in the school, and their mother is the director of this school. Their factory produces chemicals, " +
                "and Magne's classmate suspects that the Jutuls have somehow polluted the local fjord with mercury. " +
                "Magne is drawn into her righteous struggle and soon discovers a superpower: he can throw a hammer " +
                "more than 500 meters.",
        R.drawable.ragnarok,),
    FilmRepository(3,
        "LA CASA DE PAPEL",
        "2020, action, thriller, crime, detective",
        "Country: Spain" +
                "\nEight thieves take hostages and lock themselves in the Royal Mint of Spain, while a criminal " +
                "authority manipulates the police to implement his plan.",
        R.drawable.la_casa_de_papel,),
    FilmRepository(4,
        "SLEEPLESS",
        "2021, science fiction, Drama, action, Thriller, adventure",
        "Country: USA" +
                "\nRelease date: 2021 (world)" +
                "\nAs a result of a global catastrophe, electronic devices stop working and people lose the ability " +
                "to sleep. The world is plunging into chaos. Only Jill, a former servicewoman with a difficult past, " +
                "may have the key to salvation — her own daughter.",
        R.drawable.sleepless),
    FilmRepository(
        5,
        "WISH DRAGON",
        "2021, cartoon, fantasy, comedy, adventure, family",
        "Countries: China, USA, Hong Kong" +
                "\nRelease date: 2021 (world)" +
                "\nAn ordinary guy accidentally releases a pink dragon from a teapot that fulfills wishes. The dragon " +
                "has been imprisoned for many centuries, and now he is terribly interested in how the world has changed " +
                "during this time.",
        R.drawable.wish_dragon,
    )
)
private val favoriteFilmCollection = ArrayList<FilmConstructor>()

fun getFavoriteFilms() : ArrayList<FilmConstructor> {
    favoriteFilmCollection.clear()
    for (item in listOf(FilmRepository(getRussianCities()))) {
        if (item.isFavorite)
            favoriteFilmCollection.add(item)
        else
            favoriteFilmCollection.remove(item)
    }
    return favoriteFilmCollection
}
package com.android.appvideo.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.appvideo.R
import com.android.appvideo.data.FilmConstructor
import com.android.appvideo.data.FilmRepository
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.annotations.NotNull

class FavoriteFragment : Fragment() {
    @JvmField var RECYCLER: RecyclerView? = null
    var clickListener: OnFilmClickListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        initRecycler(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initToolbar()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnFilmClickListener) {
            clickListener = context
        } else {
            Throwable("Activity must implement OnFilmClickListener")
        }
    }

    private fun initToolbar() {
        (activity as AppCompatActivity).supportActionBar
            ?.setDisplayHomeAsUpEnabled(true)

        requireActivity().findViewById<AppBarLayout>(R.id.appbar).setExpanded(false, false)
        requireActivity().findViewById<CollapsingToolbarLayout>(R.id.main_collapsing).title = resources.getString(R.string.navigate_favorites)
        requireActivity().findViewById<ImageView>(R.id.expandedImage).apply{
            setImageResource(R.drawable.black_screen)
            adjustViewBounds = false
        }
    }

    private fun initRecycler(view: View) {
        if (view is RecyclerView) {
            with(view){
                RECYCLER = this
                layoutManager = LinearLayoutManager(context)
                val favoriteFilms : ArrayList<FilmConstructor> = FilmRepository.getFavoriteFilms()
                adapter = MainViewRecycler (favoriteFilms,
                    clickListener = {
                            filmItem, _ ->
                        clickListener?.onClick(filmItem.id)
                    },
                    likeClickListener = {
                            filmItem, position ->
                        filmItem.isFavorite = !filmItem.isFavorite
                        favoriteFilms.remove(filmItem)
                        this.adapter?.notifyItemRemoved(position)
                        this.adapter?.notifyItemRangeChanged(position, favoriteFilms.size - position)
                        Snackbar.make(this, R.string.delete_movie_film, Snackbar.LENGTH_SHORT).apply {
                            setAction(R.string.Undo) {
                                filmItem.isFavorite = !filmItem.isFavorite
                                favoriteFilms.add(position, filmItem)
                                this@with.adapter?.notifyItemInserted(position)
                                this@with.adapter?.notifyItemRangeChanged(
                                    position,favoriteFilms.size - position)
                            }}.show()
                    }
                )
                val filmDecoration = CustomDecorator(requireContext(), DividerItemDecoration.VERTICAL)
                ContextCompat.getDrawable(requireActivity(), R.drawable.line_black)?.let {
                    filmDecoration.setDrawable(it)
                }
                addItemDecoration(filmDecoration)
            }
        }
    }
}
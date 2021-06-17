package com.android.appvideo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.appvideo.R
import com.android.appvideo.data.FilmRepository
import com.google.android.material.appbar.CollapsingToolbarLayout

class DetailFragment : Fragment() {
    companion object {
        private const val FILM_ID_EXTRA = "FILM_ID_EXTRA"
        fun newInstance(filmId: Int): DetailFragment {
            val args = Bundle()
            args.putInt(FILM_ID_EXTRA, filmId)

            val newFragment = DetailFragment()
            newFragment.arguments = args
            return newFragment
        }
    }

    private var filmId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        filmId = arguments?.getInt(FILM_ID_EXTRA) ?: 0
        with(FilmRepository.filmConstructor[filmId]) {
            view.findViewById<TextView>(R.id.film_name).text = this.name
            view.findViewById<TextView>(R.id.descr).text = this.descriptionDetail

            initToolbar(this.name, this.imageID)
        }
    }

    private fun initToolbar(title: String, imageId: Int) {
        (activity as AppCompatActivity).supportActionBar
            ?.setDisplayHomeAsUpEnabled(true)

        (requireActivity().findViewById<ImageView>(R.id.expandedImage))?.let { imageView ->
            imageView.setImageResource(imageId)
            imageView.visibility = View.VISIBLE
            imageView.adjustViewBounds = true
            imageView.maxHeight = resources.getDimension(R.dimen.image_height).toInt()
        }
        requireActivity().findViewById<CollapsingToolbarLayout>(R.id.main_collapsing).title = title
    }
}
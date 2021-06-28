package com.android.appvideo.ui.main

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.appvideo.R
import com.android.appvideo.data.FilmConstructor
import com.android.appvideo.data.FilmRepository
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.snackbar.Snackbar
import com.android.appvideo.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_activity.*

@Suppress("NAME_SHADOWING")
class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding
    private var isDataSetRus: Boolean = true
    private val viewModel: MainViewModel by viewModel

    private var adapter: MainFragmentAdapter? = null

var clickListener: OnFilmClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        initRecyclerView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initToolbar()
        binding.list.setOnClickListener { changeWeatherDataSet() }
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getFilmRepositoryFromLocalSourceRus()
    }

    private fun initToolbar() {
        (activity as AppCompatActivity).supportActionBar
            ?.setDisplayHomeAsUpEnabled(false)

        requireActivity().findViewById<AppBarLayout>(R.id.appbar).setExpanded(false, false)
        requireActivity().findViewById<CollapsingToolbarLayout>(R.id.main_collapsing).title = resources.getString(R.string.film_nav)
        requireActivity().findViewById<ImageView>(R.id.expandedImage).apply {
            setImageResource(R.drawable.black_screen)
            adjustViewBounds = false
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnFilmClickListener) {
            clickListener = context
        } else {
            Throwable("Activity must implement OnFilmClickListener")
        }
    }

    private fun initRecyclerView(view: View) {
        if (view is RecyclerView) {
            with(view) {
                Companion.RECYCLER = this
                layoutManager =
                    if (activity?.resources?.configuration?.orientation == Configuration.ORIENTATION_PORTRAIT) {
                        LinearLayoutManager(context)
                    } else {
                        GridLayoutManager(context, 2)
                    }

                val films: ArrayList<FilmConstructor> = FilmRepository.filmConstructor
                adapter =
                    MainViewRecycler(films,
                        clickListener = { filmItem, _ ->
                            clickListener?.onClick(filmItem.id)
                        },
                        likeClickListener = { filmItem, position ->
                            filmItem.isFavorite = !filmItem.isFavorite
                            this.adapter?.notifyItemChanged(position)
                            val text =
                                if (filmItem.isFavorite) resources.getString(R.string.app_movie_film)
                                else resources.getString(R.string.delete_movie_film)
                            Snackbar.make(this, text, Snackbar.LENGTH_SHORT).apply {
                                setAction(R.string.Undo) {
                                    filmItem.isFavorite = !filmItem.isFavorite
                                    this@with.adapter?.notifyItemChanged(position)
                                }
                            }.show()
                        }
                    )

                val filmDecoration =
                    CustomDecorator(requireContext(), DividerItemDecoration.VERTICAL)
                ContextCompat.getDrawable(requireActivity(), R.drawable.line_black)?.let {
                    filmDecoration.setDrawable(it)
                }
                addItemDecoration(filmDecoration)
            }
        }
    }

    companion object {
        @JvmField
        var RECYCLER: RecyclerView? = null
    }

    private fun changeWeatherDataSet() = with(binding) {
        if (isDataSetRus) {
            viewModel.getFilmRepositoryFromLocalSourceWorld()
            mainFragmentFAB.setImageResource(R.drawable.ic_earth)
        } else {
            viewModel.getFilmRepositoryFromLocalSourceRus()
            mainFragmentFAB.setImageResource(R.drawable.ic_russia)
        }
        isDataSetRus = !isDataSetRus
    }
    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                list.visibility = View.GONE
                adapter = MainFragmentAdapter(object : OnItemViewClickListener {
                    override fun onItemViewClick(FilmRepository1: FilmRepository) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(DetailFragment.BUNDLE_EXTRA, FilmRepository)
                            }
                            manager.beginTransaction()
                                .add(R.id.list, DetailFragment.newInstance(bundle))
                                .addToBackStack("")
                                .commitAllowingStateLoss()
                        }
                    }
                }
                ).apply {
                    setWeather(appState.FilmRepositoryData)
                }
                list.adapter = adapter
            }
            is AppState.Loading -> {
                list.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                list.visibility = View.GONE

                mainFragmentFAB.showSnackBar(
                    getString(R.string.error),
                    getString(R.string.reload),
                    { viewModel.getFilmRepositoryFromLocalSourceRus() }
                )
            }
        }
    }
    interface OnItemViewClickListener {
        fun onItemViewClick(FilmRepository1: FilmRepository)
    }
}

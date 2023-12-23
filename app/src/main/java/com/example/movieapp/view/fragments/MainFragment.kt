package com.example.movieapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import com.example.movieapp.databinding.FragmentMainBinding
import com.example.movieapp.model.MovieModel
import com.example.movieapp.presenter.MoviePresenter
import com.example.movieapp.view.MovieView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() ,MovieView{
    lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var presenter: MoviePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickes()
        presenter.attachView(this)
    }

    private fun initClickes() {
        with(binding){
            getFilmBtn.setOnClickListener {
                presenter.getMovie(nameEd.text.toString())
            }
        }
    }

    override fun showMovie(movieModel: MovieModel) {
        with(binding){
            infoTv.text = "${movieModel.year} \n ${movieModel.actors} \n ${movieModel.awards} \n ${movieModel.rating}"
        posterView.load(movieModel.poster)
        }
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

}
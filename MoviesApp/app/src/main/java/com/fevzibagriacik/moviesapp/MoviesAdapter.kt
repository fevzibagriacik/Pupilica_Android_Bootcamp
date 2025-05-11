package com.fevzibagriacik.moviesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fevzibagriacik.moviesapp.databinding.CardDesignBinding
import com.fevzibagriacik.moviesapp.databinding.FragmentMainPageBinding
import com.google.android.material.snackbar.Snackbar

class MoviesAdapter(var mContext:Context, var moviesList:List<Filmler>)
    : RecyclerView.Adapter<MoviesAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(var design:CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        var design = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val movie = moviesList.get(position)
        val d = holder.design

        d.textViewPrice.text = "${movie.price} ₺"
        d.imageViewMovie.setImageResource(
            mContext.resources.getIdentifier(movie.image, "drawable", mContext.packageName)
        )

        d.buttonBasket.setOnClickListener {
            Snackbar.make(it, "${movie.name} is added to the basket", Snackbar.LENGTH_SHORT).show()
        }

        d.cardViewMovie.setOnClickListener{
            val transition = MainPageFragmentDirections.toDetail(movieObject = movie)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}
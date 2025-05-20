package com.fevzibagriacik.foodapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fevzibagriacik.foodapp.R
import com.fevzibagriacik.foodapp.data.entity.Food
import com.fevzibagriacik.foodapp.databinding.CardDesignBinding
import com.fevzibagriacik.foodapp.ui.fragment.MainPageFragment
import com.fevzibagriacik.foodapp.ui.fragment.MainPageFragmentDirections

class FoodAdapter(var mContext:Context, var foodList:List<Food>)
    : RecyclerView.Adapter<FoodAdapter.CardDesignHolder>(){
        inner class CardDesignHolder(var binding:CardDesignBinding)
            : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignBinding.inflate(LayoutInflater.from(mContext),
            parent, false)

        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food = foodList.get(position)
        val b = holder.binding

        b.tvName.text = "${food.name}"
        b.tvPrice.text = "${food.price} ₺"
        b.ivFood.setImageResource(
            mContext.resources.getIdentifier(food.image,
                "drawable", mContext.packageName)
        )

        b.ivFood.setOnClickListener {
            val transition = MainPageFragmentDirections.toDetail(food = food)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}
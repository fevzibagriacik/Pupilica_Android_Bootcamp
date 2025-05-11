package com.fevzibagriacik.homework_6.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fevzibagriacik.homework_6.R
import com.fevzibagriacik.homework_6.data.entity.Food
import com.fevzibagriacik.homework_6.databinding.CardDesignBinding
import com.fevzibagriacik.homework_6.ui.fragment.MainPageFragment
import com.fevzibagriacik.homework_6.ui.fragment.MainPageFragmentDirections

class FoodAdapter(var mContext:Context, var foodList:List<Food>)
    :RecyclerView.Adapter<FoodAdapter.CardDesignHolder>(){

        inner class CardDesignHolder(var design:CardDesignBinding)
            : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val design = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food =  foodList.get(position)
        val d = holder.design

        d.tvFoodName.text = food.foodName
        d.tvRestaurantName.text = food.restaurantName
        d.ivFood.setImageResource(
            mContext.resources.getIdentifier(food.picture, "drawable", mContext.packageName)
        )
        d.tvRate.text = food.rate
        d.tvPrice.text = "${food.price} ₺"
        d.tvDeliveryTime.text = "${food.deliveryTime} min"

        d.ivFood.setOnClickListener {
            val transition = MainPageFragmentDirections.toDetail(food = food)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}
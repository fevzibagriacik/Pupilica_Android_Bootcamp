package com.fevzibagriacik.foodorderingapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fevzibagriacik.foodorderingapp.data.entity.Sepet_Yemekler
import com.fevzibagriacik.foodorderingapp.databinding.CardDesignBasketBinding
import com.fevzibagriacik.foodorderingapp.ui.viewmodel.BasketViewModel

class BasketFoodAdapter(var mContext:Context, var foodList:List<Sepet_Yemekler>,
                        viewModel:BasketViewModel)
    : RecyclerView.Adapter<BasketFoodAdapter.BasketFoodDesignHolder>(){

    inner class BasketFoodDesignHolder(var binding: CardDesignBasketBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketFoodDesignHolder {
        val binding = CardDesignBasketBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return BasketFoodDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketFoodDesignHolder, position: Int) {
        val food = foodList[position]
        val b = holder.binding
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

}
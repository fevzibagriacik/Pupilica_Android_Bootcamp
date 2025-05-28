package com.fevzibagriacik.foodorderingapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fevzibagriacik.foodorderingapp.data.entity.Sepet_Yemekler
import com.fevzibagriacik.foodorderingapp.data.entity.Yemekler
import com.fevzibagriacik.foodorderingapp.databinding.CardDesignBasketBinding
import com.fevzibagriacik.foodorderingapp.databinding.CardDesignMainPageBinding
import com.fevzibagriacik.foodorderingapp.ui.viewmodel.BasketViewModel

class BasketFoodAdapter(var mContext:Context,
                        var viewModel:BasketViewModel)
    : RecyclerView.Adapter<BasketFoodAdapter.BasketFoodDesignHolder>(){

    var foodList: List<Sepet_Yemekler> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class BasketFoodDesignHolder(var binding: CardDesignBasketBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketFoodDesignHolder {
        val binding = CardDesignBasketBinding.inflate(LayoutInflater.from(mContext), parent, false)

        return BasketFoodDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketFoodDesignHolder, position: Int) {
        if (position < 0 || position >= foodList.size) return

        val basketFood = foodList.getOrNull(position) ?: return
        val b = holder.binding

        b.tvBasketCardFoodName.text = basketFood.yemek_adi
        b.tvBasketCardPrice.text = "₺ ${basketFood.yemek_fiyat.toInt() * basketFood.yemek_siparis_adet}"
        b.tvBasketCardAmount.text = basketFood.yemek_siparis_adet.toString()
        showImage(basketFood.yemek_resim_adi, b)

        b.ibBasketCardIncrease.setOnClickListener {
            viewModel.increaseAmount(basketFood)
        }

        b.ibBasketCardDecrease.setOnClickListener {
            viewModel.decreaseAmount(basketFood)
        }

        b.ivDelete.setOnClickListener {
            viewModel.deleteBasketFood(basketFood.sepet_yemek_id, "Fevzi")
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun showImage(imageName:String, binding: CardDesignBasketBinding){
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$imageName"
        Glide.with(mContext).load(url).override(300, 300).into(binding.ivBasketCardFood)
    }
}
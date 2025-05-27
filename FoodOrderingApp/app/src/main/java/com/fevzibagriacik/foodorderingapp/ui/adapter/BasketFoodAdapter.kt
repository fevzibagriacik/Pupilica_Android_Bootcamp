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

class BasketFoodAdapter(var mContext:Context, var foodList:List<Sepet_Yemekler> = listOf(),
                        var viewModel:BasketViewModel)
    : RecyclerView.Adapter<BasketFoodAdapter.BasketFoodDesignHolder>(){
    inner class BasketFoodDesignHolder(var binding: CardDesignBasketBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketFoodDesignHolder {
        val binding = CardDesignBasketBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return BasketFoodDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketFoodDesignHolder, position: Int) {
        val basketFood = foodList[position]
        val b = holder.binding

        b.tvBasketCardFoodName.text = basketFood.yemek_adi
        b.tvBasketCardPrice.text = "₺ ${basketFood.yemek_fiyat.toInt() * basketFood.yemek_siparis_adet}"
        b.tvBasketCardAmount.text = basketFood.yemek_siparis_adet.toString()
        showImage(basketFood.yemek_resim_adi, b)

        b.ibBasketCardIncrease.setOnClickListener {
            increaseAmount(b, basketFood)
        }

        b.ibBasketCardDecrease.setOnClickListener {
            decreaseAmount(b, basketFood)
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

    fun increaseAmount(binding:CardDesignBasketBinding, food:Sepet_Yemekler){
        food.yemek_siparis_adet++
        val price = food.yemek_siparis_adet * food.yemek_fiyat.toInt()

        binding.tvBasketCardPrice.text = "₺ $price"
        binding.tvBasketCardAmount.text = food.yemek_siparis_adet.toString()
    }

    fun decreaseAmount(binding:CardDesignBasketBinding, food:Sepet_Yemekler){
        if(food.yemek_siparis_adet > 1){
            food.yemek_siparis_adet--
            val price = food.yemek_siparis_adet * food.yemek_fiyat.toInt()

            binding.tvBasketCardPrice.text = "₺ $price"
            binding.tvBasketCardAmount.text = food.yemek_siparis_adet.toString()
        }
    }
}
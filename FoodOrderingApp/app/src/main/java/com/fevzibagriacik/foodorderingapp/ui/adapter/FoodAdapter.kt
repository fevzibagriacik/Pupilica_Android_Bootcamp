package com.fevzibagriacik.foodorderingapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fevzibagriacik.foodorderingapp.R
import com.fevzibagriacik.foodorderingapp.data.entity.Yemekler
import com.fevzibagriacik.foodorderingapp.databinding.CardDesignMainPageBinding
import com.fevzibagriacik.foodorderingapp.ui.fragment.MainPageFragmentDirections
import com.fevzibagriacik.foodorderingapp.ui.viewmodel.MainPageViewModel

class FoodAdapter(var mContext:Context, var foodList:List<Yemekler>, var viewModel:MainPageViewModel)
    : RecyclerView.Adapter<FoodAdapter.MainCardDesignHolder>(){

    inner class MainCardDesignHolder(var binding:CardDesignMainPageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCardDesignHolder {
        val binding = CardDesignMainPageBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return MainCardDesignHolder(binding)
    }
//Adapterda kaldık buraya veri çekcez
    override fun onBindViewHolder(holder: MainCardDesignHolder, position: Int) {
        val food = foodList[position]
        val b = holder.binding

        b.tvMainCardFoodName.text = food.yemek_adi
        b.tvMainCardFoodPrice.text = "₺ ${food.fiyat}"
        showImage(food.yemek_resim_adi, b)

        b.ivFoodMainCard.setOnClickListener {
            val transition = MainPageFragmentDirections.toDetailFromMain(food)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun showImage(imageName:String, binding:CardDesignMainPageBinding){
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$imageName"
        Glide.with(mContext).load(url).override(300, 300).into(binding.ivFoodMainCard)
    }

}
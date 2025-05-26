package com.fevzibagriacik.foodorderingapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.fevzibagriacik.foodorderingapp.R
import com.fevzibagriacik.foodorderingapp.data.entity.Yemekler
import com.fevzibagriacik.foodorderingapp.databinding.CardDesignMainPageBinding
import com.fevzibagriacik.foodorderingapp.databinding.FragmentDetailBinding
import com.fevzibagriacik.foodorderingapp.ui.viewmodel.DetailViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel:DetailViewModel
    private var amount = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle:DetailFragmentArgs by navArgs()
        val comingFood = bundle.food

        binding.tvFoodName.text = comingFood.yemek_adi
        binding.tvFoodPrice.text = "₺ ${comingFood.fiyat}"
        showImage(comingFood.yemek_resim_adi)
        setPoint(requireContext(), binding, comingFood)

        binding.ibClose.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toMainFromDetail)
        }

        binding.ibIncrease.setOnClickListener {
            increaseAmount(comingFood)
        }

        binding.ibDecrease.setOnClickListener {
            decreaseAmount(comingFood)
        }

        if(comingFood.puan == 5){
            binding.ivFood
        }

        return binding.root
    }

    fun setPoint(mContext:Context, binding:FragmentDetailBinding, food:Yemekler){
        if(food.puan == 5){
            binding.ivStar1.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar2.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar3.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar4.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar5.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
        }
        else if(food.puan == 4){
            binding.ivStar1.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar2.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar3.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar4.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar5.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
        }
        else if(food.puan == 3){
            binding.ivStar1.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar2.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar3.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar4.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar5.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
        }
        else if(food.puan == 2){
            binding.ivStar1.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar2.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar3.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar4.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar5.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
        }
        else if(food.puan == 1){
            binding.ivStar1.setImageResource(
                mContext.resources.getIdentifier("full_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar2.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar3.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar4.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar5.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
        }
        else{
            binding.ivStar1.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar2.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar3.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar4.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
            binding.ivStar5.setImageResource(
                mContext.resources.getIdentifier("empty_star_image", "drawable", mContext.packageName)
            )
        }
    }

    fun showImage(imageName:String){
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$imageName"
        Glide.with(this).load(url).override(300, 300).into(binding.ivFood)
    }

    fun increaseAmount(food:Yemekler){
        amount++
        val price = amount * food.fiyat.toInt()

        binding.tvFoodPrice.text = "₺ $price"
        binding.tvAmount.text = amount.toString()
    }

    fun decreaseAmount(food:Yemekler){
        amount--
        val price = amount * food.fiyat.toInt()

        binding.tvFoodPrice.text = "₺ $price"
        binding.tvAmount.text = amount.toString()
    }
}
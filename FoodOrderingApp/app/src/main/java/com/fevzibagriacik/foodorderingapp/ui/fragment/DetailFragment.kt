package com.fevzibagriacik.foodorderingapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.fevzibagriacik.foodorderingapp.R
import com.fevzibagriacik.foodorderingapp.data.datasource.FoodDataSource
import com.fevzibagriacik.foodorderingapp.data.entity.Sepet_Yemekler
import com.fevzibagriacik.foodorderingapp.data.entity.Yemekler
import com.fevzibagriacik.foodorderingapp.data.repo.FoodRepo
import com.fevzibagriacik.foodorderingapp.databinding.CardDesignMainPageBinding
import com.fevzibagriacik.foodorderingapp.databinding.FragmentDetailBinding
import com.fevzibagriacik.foodorderingapp.ui.viewmodel.DetailViewModel
import com.google.android.material.snackbar.Snackbar

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel:DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val dataSource = FoodDataSource()
        val repo = FoodRepo(dataSource)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return DetailViewModel(repo) as T
            }
        })[DetailViewModel::class.java]

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

        binding.buttonBasket.setOnClickListener {
            val addedFood = Sepet_Yemekler(0, comingFood.yemek_adi,
                comingFood.yemek_resim_adi, comingFood.fiyat, comingFood.amount, "Fevzi")

            viewModel.addFoodToBasket(addedFood.yemek_adi, addedFood.yemek_resim_adi,
                addedFood.yemek_fiyat, addedFood.yemek_siparis_adet, addedFood.kullanici_adi)

            Log.e("Added Food", "${addedFood.yemek_adi} - ${addedFood.yemek_resim_adi} - " +
                    "${addedFood.yemek_fiyat} - ${addedFood.yemek_siparis_adet} - ${addedFood.kullanici_adi}")

            AlertDialog.Builder(requireContext())
                .setMessage("Food is added to the basket.")
                .setPositiveButton("OK") { dialog, _ ->
                    Navigation.findNavController(it).navigate(R.id.toMainFromDetail)
                    dialog.dismiss()
                }
                .show()
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
        food.amount++
        val price = food.amount * food.fiyat.toInt()

        binding.tvFoodPrice.text = "₺ $price"
        binding.tvAmount.text = food.amount.toString()
    }

    fun decreaseAmount(food:Yemekler) {
        if (food.amount > 1) {
            food.amount--
            val price = food.amount * food.fiyat.toInt()

            binding.tvFoodPrice.text = "₺ $price"
            binding.tvAmount.text = food.amount.toString()
        }
    }
}
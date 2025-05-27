package com.fevzibagriacik.foodorderingapp.retrofit

import com.fevzibagriacik.foodorderingapp.data.entity.CRUDCevap
import com.fevzibagriacik.foodorderingapp.data.entity.SepetYemeklerCevap
import com.fevzibagriacik.foodorderingapp.data.entity.Sepet_Yemekler
import com.fevzibagriacik.foodorderingapp.data.entity.YemeklerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDao {
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun uploadFoods() : YemeklerCevap

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addFoodToBasket(@Field("yemek_adi") yemek_adi:String,
                                @Field("yemek_resim_adi") yemek_resim_adi:String,
                                @Field("yemek_fiyat") yemek_fiyat:String,
                                @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
                                @Field("kullanici_adi") kullanici_adi:String) : CRUDCevap

    @FormUrlEncoded
    @POST("yemekler/sepettekiYemekleriGetir.php")
    suspend fun uploadBasketFoods(@Field("kullanici_adi") userName:String)
    : SepetYemeklerCevap

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun deleteBasketFood(@Field("sepet_yemek_id") sepet_yemek_id:Int,
                                 @Field("kullanici_adi") kullanici_adi:String) : CRUDCevap
}
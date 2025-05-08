package com.fevzibagriacik.personsapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fevzibagriacik.personsapp.data.entity.Kisiler
import com.fevzibagriacik.personsapp.databinding.CardDesignBinding
import com.fevzibagriacik.personsapp.databinding.FragmentMainPageBinding
import com.fevzibagriacik.personsapp.ui.fragment.MainPageFragmentDirections
import com.google.android.material.snackbar.Snackbar

class PersonsAdapter(var mContext: Context, var personList: List<Kisiler>)
    : RecyclerView.Adapter<PersonsAdapter.CardDesignHolder>(){
    //context provides that we know which page

    inner class CardDesignHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        //Access
        val design = CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        //Process
        val person = personList.get(position) //position gets persons as 0, 1, 2...
        val t = holder.design
        t.textViewPersonName.text = person.kisi_ad
        t.textViewNumber.text = person.kisi_tel

        t.cardViewRow.setOnClickListener{
            val transition = MainPageFragmentDirections.toPersonDetail(person = person)
            Navigation.findNavController(it).navigate(transition)
        }

        t.imageViewDelete.setOnClickListener{
            Snackbar.make(it, "${person.kisi_ad} delete?", Snackbar.LENGTH_SHORT)
                .setAction("Yes"){
                    delete(person.kisi_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return personList.size //How many
    }

    fun delete(person_id:Int){
        Log.e("Delete Person", person_id.toString())
    }
}
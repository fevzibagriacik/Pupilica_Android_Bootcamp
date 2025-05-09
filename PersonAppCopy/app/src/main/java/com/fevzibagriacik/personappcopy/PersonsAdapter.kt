package com.fevzibagriacik.personappcopy

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fevzibagriacik.personappcopy.databinding.CardDesignBinding
import com.google.android.material.snackbar.Snackbar

class PersonsAdapter(var mContext:Context, var personList:List<Persons>)
    :RecyclerView.Adapter<PersonsAdapter.CardHolder>(){
        inner class CardHolder(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignBinding.inflate(layoutInflater, parent, false)
        return CardHolder(design)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val person = personList.get(position)
        val t = holder.design
        t.tvPersonName.text = person.person_name
        t.tvPersonNumber.text = person.person_number

        t.cardViewRow.setOnClickListener{
            val transition = MainPageFragmentDirections.toPersonDetail(person = person)
            Navigation.findNavController(it).navigate(transition)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Should ${person.person_name} be deleted?", Snackbar.LENGTH_SHORT)
                .setAction("Yes"){
                    Log.e("Delete Person", person.person_id.toString())
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}
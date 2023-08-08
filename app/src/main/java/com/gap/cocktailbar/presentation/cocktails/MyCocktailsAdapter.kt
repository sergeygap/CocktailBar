package com.gap.cocktailbar.presentation.cocktails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gap.cocktailbar.R
import com.gap.cocktailbar.data.Cocktails

class MyCocktailsAdapter : RecyclerView.Adapter<MyCocktailsAdapter.MyCocktailsViewHolder>() {

    private var cocktails: List<Cocktails> = ArrayList()

    fun getCocktails(): List<Cocktails> {
        return ArrayList<Cocktails>(this.cocktails)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCocktails(cocktails: List<Cocktails>) {
        this.cocktails = cocktails
        notifyDataSetChanged()
    }

    class MyCocktailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName: TextView

        init {
            textViewName = itemView.findViewById(R.id.textViewName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCocktailsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_recycler,
            parent,
            false
        )
        return MyCocktailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cocktails.size
    }

    override fun onBindViewHolder(holder: MyCocktailsViewHolder, position: Int) {
        val cocktails = cocktails[position]
        holder.textViewName.text = cocktails.title


        holder.itemView.setOnClickListener {

        }

    }
}
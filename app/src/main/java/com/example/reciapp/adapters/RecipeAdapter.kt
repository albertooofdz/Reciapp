package com.example.reciapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.reciapp.R
import com.example.reciapp.data.RecipeItemResponse
import com.example.reciapp.databinding.ItemListBinding
import com.squareup.picasso.Picasso

class RecipeAdapter(
    var recipesList: List<RecipeItemResponse> = emptyList(),
    private val onItemSelected: (Int, String) -> Unit
) :
    RecyclerView.Adapter<RecipeViewHolder>() {

    fun updateList(recipesList: List<RecipeItemResponse>) {

        this.recipesList = recipesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return RecipeViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount() = recipesList.size


    override fun onBindViewHolder(viewholder: RecipeViewHolder, position: Int) {

        viewholder.bind(recipesList[position],onItemSelected)
    }

}


class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemListBinding.bind(view)
    fun bind(recipeItemResponse: RecipeItemResponse, onItemSelected: (Int, String) -> Unit) {
        binding.recipeNameTV.text = recipeItemResponse.name

        Picasso.get().load(recipeItemResponse.image).into(binding.recipeImageIv)
        binding.root.setOnClickListener{ onItemSelected(recipeItemResponse.id, recipeItemResponse.image)}

        binding.prepTimeTV.text= (recipeItemResponse.prepTimeMinutes+recipeItemResponse.cookTimeMinutes).toString() + "'"

        binding.difficultTV.text=recipeItemResponse.difficulty

        binding.scoreTV.text= recipeItemResponse.rating.toString()




    }



}
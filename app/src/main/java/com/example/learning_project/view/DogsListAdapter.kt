package com.example.learning_project.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.learning_project.R
import com.example.learning_project.model.DogBreed
import com.example.learning_project.util.getProgressDrawable
import com.example.learning_project.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogList: ArrayList<DogBreed>): RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateDogList(newDogList: List<DogBreed>) {
        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DogsListAdapter.DogViewHolder {
        return DogViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_dog,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DogsListAdapter.DogViewHolder, position: Int) {
        val curDog = dogList[position]
        holder.view.name.text = curDog.dogBreed
        holder.view.lifeSpan.text = curDog.lifeSpan
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailFragment())
        }
        holder.view.imageView.loadImage(curDog.imageUrl, getProgressDrawable(holder.view.imageView.context))
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

}
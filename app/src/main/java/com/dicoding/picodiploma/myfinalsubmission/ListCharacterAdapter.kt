package com.dicoding.picodiploma.myfinalsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ListCharacterAdapter(private val listCharacter: ArrayList<Character>): RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_character, parent, false))
    }

    override fun getItemCount(): Int = listCharacter.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, detail, voice) = listCharacter[position]
        holder.photo.setImageResource(photo)
        holder.name.text = name
        holder.description.text = description

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailCharacterActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("description", description)
            intent.putExtra("detail", detail)
            intent.putExtra("voice", voice)
            intent.putExtra("photo", photo)
            holder.itemView.context.startActivities(arrayOf(intent))
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.img_item_photo)
        val name: TextView = itemView.findViewById(R.id.tv_item_name)
        val description: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}
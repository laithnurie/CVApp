package com.laithlab.cvapp.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laithlab.cvapp.R
import kotlin.math.exp

class ExperiencesAdapter(private val context: Context, private val experiences: ArrayList<ExperienceUIModel>) :
    RecyclerView.Adapter<ExperiencesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.experience_item, parent, false))
    }

    override fun getItemCount(): Int {
        return experiences.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val experience = experiences[position]
        holder.experienceView.setup(experience)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal val experienceView: ExperienceView = itemView.findViewById(R.id.experience_view)

    }

}
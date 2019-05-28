package com.laithlab.cvapp.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.laithlab.cvapp.R

class SkillsAdapter(private val context: Context, private val skills: ArrayList<SkillUIModel>) :
    RecyclerView.Adapter<SkillsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.skill_item, parent, false))
    }

    override fun getItemCount(): Int {
        return skills.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skill = skills[position]
        holder.name.text = skill.name
        holder.level.text = "lvl: ${skill.level}"
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal val name: TextView = itemView.findViewById(R.id.skill_name)
        internal val level: TextView = itemView.findViewById(R.id.skill_level)

    }

}
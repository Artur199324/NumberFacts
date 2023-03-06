package com.hos.mager.numberfacts.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hos.mager.numberfacts.R
import com.hos.mager.numberfacts.data.room.MathFact

class MathFactAdapter(private val mathFacts: List<MathFact>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<MathFactAdapter.MathFactViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(mathFact: MathFact)
    }

    class MathFactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val factTextView: TextView = view.findViewById(R.id.textView2)

        fun bind(mathFact: MathFact) {
            factTextView.text = mathFact.fact.substring(0, 10)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MathFactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_math_fact, parent, false)
        return MathFactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mathFacts.size
    }

    override fun onBindViewHolder(holder: MathFactViewHolder, position: Int) {
        val mathFact = mathFacts[position]
        holder.bind(mathFact)
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(mathFact)
        }
    }
}
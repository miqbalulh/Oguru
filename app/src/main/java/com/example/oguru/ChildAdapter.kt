package com.example.oguru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.children_recyclerview.view.*

class ChildAdapter(private val children : List<childModel>)
    : RecyclerView.Adapter<ChildAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val v =  LayoutInflater.from(parent.context)
            .inflate(R.layout.children_recyclerview,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val child = children[position]
        holder.textViewMapel.text = child.mapel
        holder.textViewJam.text = child.jam
        holder.textViewAlamat.text = child.alamat
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val textViewMapel : TextView = itemView.mapel
        val textViewJam : TextView = itemView.jam
        val textViewAlamat : TextView = itemView.alamat

    }
}
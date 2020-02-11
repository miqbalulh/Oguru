package com.example.oguru

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.children_recyclerview.view.*
import kotlinx.android.synthetic.main.parent_recyclerview.view.*

class ParentAdapter(private val parents : List<parentModel>) :   RecyclerView.Adapter<ParentAdapter.ViewHolder>(){

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_recyclerview,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        val parent = parents[position]
        holder.textView.text = parent.jadwal
        val childLayoutManager = LinearLayoutManager(holder.recyclerView.context, RecyclerView.VERTICAL,false)
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = ChildAdapter(parent.Children)
            setRecycledViewPool(viewPool)
        }


    }
    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.rvdetail
        val textView: TextView = itemView.tanggal

    }

}
package com.example.oguru.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oguru.ParentAdapter
import com.example.oguru.ParentDataFactory
import com.example.oguru.R
import com.example.oguru.parentModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.parent_recyclerview.*

class HomeFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home , container, false)
        val fab = root.findViewById<FloatingActionButton>(R.id.pesan)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        initRecycler(root)
        return root
    }

    private fun initRecycler(view: View){

        recyclerView = view.findViewById(R.id.parentrv)
        val layoutManagerPlease = LinearLayoutManager(recyclerView.context,RecyclerView.VERTICAL,false)
        recyclerView.apply {
            layoutManager = layoutManagerPlease
            adapter = ParentAdapter(ParentDataFactory.getParents(10))

        }


    }



}
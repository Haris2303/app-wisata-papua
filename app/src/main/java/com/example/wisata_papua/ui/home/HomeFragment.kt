package com.example.wisata_papua.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisata_papua.R
import com.example.wisata_papua.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        //        Init recycle view
        val recyclerView: RecyclerView = binding.listCard
        recyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

//        Data untuk ditampilkan data ListView
        val dataList = listOf(
            ItemData(R.drawable.hero, "Pantai 1"),
            ItemData(R.drawable.hero, "Pantai 2"),
            ItemData(R.drawable.hero, "Pantai 3"),
            ItemData(R.drawable.hero, "Pantai 4"),
            ItemData(R.drawable.hero, "Pantai 4"),
            ItemData(R.drawable.hero, "Pantai 4"),
            ItemData(R.drawable.hero, "Pantai 4"),
            ItemData(R.drawable.hero, "Pantai 4"),
            ItemData(R.drawable.hero, "Pantai 4"),
        )
//        Membuat adapter
        val adapter = CardAdapter(dataList)

        recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
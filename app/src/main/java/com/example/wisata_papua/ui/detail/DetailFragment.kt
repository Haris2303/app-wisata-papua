package com.example.wisata_papua.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.wisata_papua.R

class DetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil data dari arguments
        val title = arguments?.getString("TITLE")

        // Set data ke TextView
        val titleTextView: TextView = view.findViewById(R.id.tv_title_detail)

        titleTextView.text = title
    }

    companion object {
        // Method untuk membuat instance Fragment dengan data
        fun newInstance(title: String): DetailFragment {
            val fragment = DetailFragment()
            val bundle = Bundle()

            bundle.putString("TITLE", title)
            fragment.arguments = bundle

            return fragment
        }
    }

}
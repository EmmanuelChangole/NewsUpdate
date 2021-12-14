package com.example.newsupdate.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsupdate.R
import com.example.newsupdate.viewModel.SkillsViewModel

class SkillsFragment : Fragment() {

    companion object {
        fun newInstance() = SkillsFragment()
    }

    private lateinit var viewModel: SkillsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.skills_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SkillsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
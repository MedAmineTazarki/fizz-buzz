package com.tazarki.fizzbuzz.dashboard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.tazarki.fizzbuzz.R
import com.tazarki.fizzbuzz.dashboard.viewmodel.DashboardViewModel
import com.tazarki.fizzbuzz.dashboard.viewmodel.DashboardViewModelFactory

class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by activityViewModels {
        DashboardViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val requestItemAdapter = RequestItemAdapter()
        val list: RecyclerView = root.findViewById(R.id.list)
        list.adapter = requestItemAdapter
        list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        dashboardViewModel.requestItemsLive.observe(viewLifecycleOwner) {
            requestItemAdapter.submitList(it)
        }

        dashboardViewModel.loadRequests()

        return root
    }
}
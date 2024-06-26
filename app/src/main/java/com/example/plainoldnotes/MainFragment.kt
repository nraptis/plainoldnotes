package com.example.plainoldnotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plainoldnotes.databinding.FragmentMainBinding

class MainFragment : Fragment(),
NotesListAdapter.ListItemListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: NotesListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = FragmentMainBinding.inflate(inflater, container, false)

        with(binding.recyclerView) {
            setHasFixedSize(true)
            val divider = DividerItemDecoration(context, LinearLayoutManager(context).orientation)
            addItemDecoration(divider)
        }

        viewModel.notesList.observe(viewLifecycleOwner, Observer {
            adapter = NotesListAdapter(it, this@MainFragment)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })

        return binding.root
    }

    override fun onItemClick(noteId: Int) {
        Log.i(TAG, "received note id $noteId")
        val action = MainFragmentDirections.actionEditNote(noteId)
        findNavController().navigate(action)
    }
}
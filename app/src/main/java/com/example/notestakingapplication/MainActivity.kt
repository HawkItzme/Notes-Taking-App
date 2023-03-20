package com.example.notestakingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notestakingapplication.database.NoteDatabase
import com.example.notestakingapplication.databinding.ActivityMainBinding
import com.example.notestakingapplication.repository.NoteRepository
import com.example.notestakingapplication.viewModel.NoteViewModel
import com.example.notestakingapplication.viewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var  noteViewModel : NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()

    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))

        val viewModelProviderFactory = NoteViewModelFactory(application,
            noteRepository)

        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory)
            .get(NoteViewModel::class.java)
    }
}
package com.example.alfagift

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alfagift.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        val contacts = generateRandomContacts()

        val adapter = ContactAdapter(contacts)
        recyclerView.adapter = adapter

        binding.backButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() //
        }
    }

    private fun generateRandomContacts(): List<Contact> {
        val names = listOf("John Doe", "Jane Smith", "Alice Johnson", "Bob Brown", "Charlie Davis",
            "David Wilson", "Emma Thomas", "Frank Harris", "Grace Lee", "Henry Walker"
        )
        return names.map { name ->
            val phone = "08" + Random.nextInt(100000000, 999999999).toString()
            Contact(name, phone)
        }
    }
}
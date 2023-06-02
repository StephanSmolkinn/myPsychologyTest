package com.course.mypsychologytestapp.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.checkTestResultButton.setOnClickListener {
            binding.testTopic.text = "test"
            readDataTest()
            binding.resultTestTopicCardView.isVisible = true
        }
        binding.checkTopicResultButton.setOnClickListener {
            binding.testTopic.text = "topic"
            readDataTopic()
            binding.resultTestTopicCardView.isVisible = true
        }
    }

    private fun readDataTest() {
        database = FirebaseDatabase.getInstance().getReference("Test One")
        database.child(FirebaseAuth.getInstance().currentUser!!.uid).get().addOnSuccessListener {
            if (it.child("result").value != null) {
                val resultTemperament = it.child("result").value.toString()
                binding.testTopicOneResult.text = "You are $resultTemperament"
            }
            else
                binding.testTopicOneResult.text = "No result. Take the temperament test"
        }
        database = FirebaseDatabase.getInstance().getReference("Test Two")
        database.child(FirebaseAuth.getInstance().currentUser!!.uid).get().addOnSuccessListener {
            if (it.child("result").value != null) {
                val resultPersonality = it.child("result").value.toString()
                binding.testTopicTwoResult.text = "You are $resultPersonality"
            }
            else
                binding.testTopicTwoResult.text = "No result. take the personality test"
        }
    }

    private fun readDataTopic() {
        database = FirebaseDatabase.getInstance().getReference("Topic One")
        database.child(FirebaseAuth.getInstance().currentUser!!.uid).get().addOnSuccessListener {
            if(it.child("result").value != null)
                binding.testTopicOneResult.text = "You read temperament topic "
            else
                binding.testTopicOneResult.text = "Temperament topic not read yet"
        }
        database = FirebaseDatabase.getInstance().getReference("Topic Two")
        database.child(FirebaseAuth.getInstance().currentUser!!.uid).get().addOnSuccessListener {
            if(it.child("result").value != null)
                binding.testTopicTwoResult.text = "You read personality topic "
            else
                binding.testTopicTwoResult.text = "Personality topic not read yet"
        }
    }

}
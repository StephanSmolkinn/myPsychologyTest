package com.course.mypsychologytestapp.ui.fragments.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.databinding.FragmentTestResultBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TestSecondResultFragment : Fragment() {

    lateinit var binding: FragmentTestResultBinding
    private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        readDataTestTwo()
    }

    private fun readDataTestTwo() {
        database = FirebaseDatabase.getInstance().getReference("Test Two")
        database.child(FirebaseAuth.getInstance().currentUser!!.uid).get().addOnSuccessListener {
            val resultPersonality = it.child("result").value.toString()
            binding.resultTextView.text = "You are $resultPersonality"
            if (resultPersonality == checkResult(resultPersonality)) {
                binding.descriptionResult.text = getDescriptionSecondTest(resultPersonality)
            }
        }
    }

}
package com.course.mypsychologytestapp.ui.fragments.test.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.databinding.FragmentTestResultBinding
import com.course.mypsychologytestapp.ui.fragments.test.description.checkResult
import com.course.mypsychologytestapp.ui.fragments.test.description.getDescriptionFirstTest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TestFirstResultFragment : Fragment() {

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
        readDataTestOne()
    }

    private fun readDataTestOne() {
        database = FirebaseDatabase.getInstance().getReference("Test One")
        database.child(FirebaseAuth.getInstance().currentUser!!.uid).get().addOnSuccessListener {
            val resultTemperament = it.child("result").value.toString()
            binding.resultTextView.text = "You are $resultTemperament"
            if (resultTemperament == checkResult(resultTemperament)) {
                binding.descriptionResult.text = getDescriptionFirstTest(resultTemperament)
            }
        }
    }

}
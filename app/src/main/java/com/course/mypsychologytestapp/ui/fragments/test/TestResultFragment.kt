package com.course.mypsychologytestapp.ui.fragments.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.databinding.FragmentTestResultBinding
import com.google.firebase.auth.FirebaseAuth

class TestResultFragment : Fragment() {

    lateinit var binding: FragmentTestResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         FirebaseAuth.getInstance().currentUser?.let {

         }
    }

}
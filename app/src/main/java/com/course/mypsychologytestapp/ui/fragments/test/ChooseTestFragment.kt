package com.course.mypsychologytestapp.ui.fragments.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentChooseTestBinding
import com.course.mypsychologytestapp.ui.fragments.test.process.TestOneProcessFragment
import com.course.mypsychologytestapp.ui.fragments.test.process.TestTwoProcessFragment
import com.course.mypsychologytestapp.utils.transaction

class ChooseTestFragment : Fragment() {

    lateinit var binding: FragmentChooseTestBinding
    var number: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseTestBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.startTest1Button.setOnClickListener {
            transaction(R.id.containerTest, TestOneProcessFragment(), activity as AppCompatActivity)
        }
        binding.startTest2Button.setOnClickListener {
            transaction(R.id.containerTest, TestTwoProcessFragment(), activity as AppCompatActivity)
        }
    }

}
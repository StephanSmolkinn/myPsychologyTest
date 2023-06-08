package com.course.mypsychologytestapp.ui.fragments.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentChooseTestBinding
import com.course.mypsychologytestapp.ui.fragments.test.process.TestOneProcessFragment
import com.course.mypsychologytestapp.ui.fragments.test.process.TestTwoProcessFragment

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
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.containerTest, TestOneProcessFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        binding.startTest2Button.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.containerTest, TestTwoProcessFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
    }

}
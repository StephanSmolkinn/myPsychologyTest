package com.course.mypsychologytestapp.ui.fragments.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentChooseTopicBinding

class ChooseTopicFragment : Fragment() {

    lateinit var binding: FragmentChooseTopicBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseTopicBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.startTopic1Button.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.containerTopic, TopicOneFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        binding.startTopic2Button.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.containerTopic, TopicTwoFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
    }

}
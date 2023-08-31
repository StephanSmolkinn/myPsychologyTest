package com.course.mypsychologytestapp.ui.fragments.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentChooseTopicBinding
import com.course.mypsychologytestapp.utils.transaction

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
            transaction(R.id.containerTopic, TopicOneFragment(), activity as AppCompatActivity)
        }
        binding.startTopic2Button.setOnClickListener {
            transaction(R.id.containerTopic, TopicTwoFragment(), activity as AppCompatActivity)
        }
    }

}
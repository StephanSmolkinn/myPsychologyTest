package com.course.mypsychologytestapp.ui.fragments.topic.contentTopicTwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.databinding.FragmentTopicTwoContentBinding
import com.course.mypsychologytestapp.ui.fragments.topic.constants.ConstantsTopic

class TopicTwoOnePageContentFragment : Fragment() {

    lateinit var binding: FragmentTopicTwoContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopicTwoContentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = "Introvert"
        binding.topicTwoName.text = name

        binding.topicTwoContent.text = ConstantsTopic.getTextTopicTwo(0)
    }

}
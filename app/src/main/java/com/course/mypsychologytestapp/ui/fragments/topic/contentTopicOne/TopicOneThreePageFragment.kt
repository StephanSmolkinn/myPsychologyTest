package com.course.mypsychologytestapp.ui.fragments.topic.contentTopicOne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.databinding.FragmentTopicOneContentBinding
import com.course.mypsychologytestapp.ui.fragments.topic.constants.ConstantsTopic

class TopicOneThreePageFragment : Fragment() {

    lateinit var binding: FragmentTopicOneContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopicOneContentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val content = "Phlegmatic"
        binding.topicOneName.text = content

        binding.topicOneContent.text = ConstantsTopic.getTextTopicOne(2)
    }

}
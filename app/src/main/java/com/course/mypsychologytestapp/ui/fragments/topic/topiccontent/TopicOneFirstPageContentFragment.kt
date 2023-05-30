package com.course.mypsychologytestapp.ui.fragments.topic.topiccontent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.databinding.FragmentTopicOneContentBinding

class TopicOneFirstPageContentFragment : Fragment() {

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
        val content = "1 Page"
        binding.textView.text = content
    }

}
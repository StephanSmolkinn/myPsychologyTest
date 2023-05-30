package com.course.mypsychologytestapp.ui.fragments.topic.topiccontent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentTopicOneContentBinding
import com.course.mypsychologytestapp.ui.HomeActivity
import com.course.mypsychologytestapp.ui.fragments.topic.ChooseTopicFragment

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
        binding.button2.isVisible = true
        binding.button2.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.containerTopic, ChooseTopicFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        val content = "3 Page"
        binding.textView.text = content
    }

}
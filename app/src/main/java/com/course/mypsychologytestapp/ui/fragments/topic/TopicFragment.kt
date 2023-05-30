package com.course.mypsychologytestapp.ui.fragments.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentTopicBinding
import com.course.mypsychologytestapp.ui.fragments.test.TestOneProcessFragment

class TopicFragment : Fragment() {

    private lateinit var binding: FragmentTopicBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopicBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.containerTopic, ChooseTopicFragment())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }

}
package com.course.mypsychologytestapp.ui.fragments.topic.contentTopicOne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentTopicOneContentBinding
import com.course.mypsychologytestapp.model.ResultFirstTopic
import com.course.mypsychologytestapp.repository.ResultFirstTopicRepository
import com.course.mypsychologytestapp.ui.fragments.topic.ChooseTopicFragment
import com.course.mypsychologytestapp.ui.fragments.topic.constants.ConstantsTopic
import com.course.mypsychologytestapp.utils.transaction
import com.google.firebase.auth.FirebaseAuth

class TopicOneFourPageFragment : Fragment() {

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
        val content = "Melancholic"
        binding.topicOneName.text = content

        binding.topicOneContent.text = ConstantsTopic.getTextTopicOne(3)

        binding.endTopicOneButton.isVisible = true
        binding.endTopicOneButton.setOnClickListener {
            updateTopicOneDatabase()
            transaction(R.id.containerTopic, ChooseTopicFragment(), activity as AppCompatActivity)
        }
    }

    private fun updateTopicOneDatabase() {
        val resultFirstTopic = ResultFirstTopic(
            uid = FirebaseAuth.getInstance().currentUser!!.uid,
            result = "read"
        )
        ResultFirstTopicRepository().createResultFirstTopic(resultFirstTopic)
    }

}
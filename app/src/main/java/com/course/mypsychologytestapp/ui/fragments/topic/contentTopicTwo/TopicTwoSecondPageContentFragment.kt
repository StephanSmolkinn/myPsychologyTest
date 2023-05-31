package com.course.mypsychologytestapp.ui.fragments.topic.contentTopicTwo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentTopicTwoContentBinding
import com.course.mypsychologytestapp.model.ResultFirstTopic
import com.course.mypsychologytestapp.model.ResultSecondTopic
import com.course.mypsychologytestapp.repository.ResultFirstTopicRepository
import com.course.mypsychologytestapp.repository.ResultSecondTopicRepository
import com.course.mypsychologytestapp.ui.fragments.topic.ChooseTopicFragment
import com.course.mypsychologytestapp.ui.fragments.topic.constants.ConstantsTopic
import com.google.firebase.auth.FirebaseAuth

class TopicTwoSecondPageContentFragment : Fragment() {

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
        val name = "Extrovert"
        binding.topicTwoName.text = name
        binding.topicTwoContent.text = ConstantsTopic.getTextTopicTwo(1)

        binding.endTopicTwoButton.isVisible = true
        binding.endTopicTwoButton.setOnClickListener {
            updateTopicTwoDatabase()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.containerTopic, ChooseTopicFragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
    }

    private fun updateTopicTwoDatabase() {
        val resultSecondTopic = ResultSecondTopic(
            uid = FirebaseAuth.getInstance().currentUser!!.uid,
            result = "read"
        )
        ResultSecondTopicRepository().createResultSecondTest(resultSecondTopic)
    }

}
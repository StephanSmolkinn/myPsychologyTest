package com.course.mypsychologytestapp.ui.fragments.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.course.mypsychologytestapp.databinding.FragmentTopicTwoBinding
import com.course.mypsychologytestapp.ui.fragments.topic.contentTopicTwo.TopicTwoOnePageContentFragment
import com.course.mypsychologytestapp.ui.fragments.topic.contentTopicTwo.TopicTwoSecondPageContentFragment

class TopicTwoFragment : Fragment() {

    lateinit var binding: FragmentTopicTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopicTwoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = TopicTwoAdapter(this)
    }
}

class TopicTwoAdapter(activity: TopicTwoFragment) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return TopicTwoOnePageContentFragment()
            1 -> return TopicTwoSecondPageContentFragment()

            else -> ChooseTopicFragment()
        }
    }
}

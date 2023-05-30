package com.course.mypsychologytestapp.ui.fragments.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.course.mypsychologytestapp.databinding.FragmentTopicOneBinding
import com.course.mypsychologytestapp.ui.fragments.home.HomeFragment
import com.course.mypsychologytestapp.ui.fragments.topic.topiccontent.TopicOneFirstPageContentFragment
import com.course.mypsychologytestapp.ui.fragments.topic.topiccontent.TopicOneThreePageFragment
import com.course.mypsychologytestapp.ui.fragments.topic.topiccontent.TopicOneTwoPageFragment

class TopicOneFragment : Fragment() {

    lateinit var binding: FragmentTopicOneBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopicOneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = TopicAdapter(this)
    }
}

class TopicAdapter(activity: TopicOneFragment) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return TopicOneFirstPageContentFragment()
            1 -> return TopicOneTwoPageFragment()
            2 -> return TopicOneThreePageFragment()

            else -> ChooseTopicFragment()
        }

    }
}
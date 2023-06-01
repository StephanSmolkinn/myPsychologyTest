package com.course.mypsychologytestapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.ActivityHomeBinding
import com.course.mypsychologytestapp.ui.fragments.home.HomeFragment
import com.course.mypsychologytestapp.ui.fragments.profile.ProfileFragment
import com.course.mypsychologytestapp.ui.fragments.test.TestFragment
import com.course.mypsychologytestapp.ui.fragments.topic.TopicFragment
import com.course.mypsychologytestapp.utils.replaceFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.item_home -> setFragment(HomeFragment())
                R.id.item_topic -> setFragment(TopicFragment())
                R.id.item_test -> setFragment(TestFragment())
                R.id.item_profile -> setFragment(ProfileFragment())
            }
            true
        }

        binding.bottomNavigationView.selectedItemId = R.id.item_home
    }

    override fun onBackPressed() {
        finishAffinity()
        finish()
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replaceFragment(R.id.container_home, fragment)
        }
    }

}
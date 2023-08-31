package com.course.mypsychologytestapp.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.ui.fragments.topic.ChooseTopicFragment

fun AppCompatActivity.replaceFragment(
    container: Int,
    fragment: Fragment,
    tag: String = fragment.javaClass.simpleName
) = supportFragmentManager
    .beginTransaction()
    .replace(container, fragment, tag)
    .commit()

fun transaction(container: Int, fragment: Fragment, activity: AppCompatActivity) {
    val transaction = activity?.supportFragmentManager?.beginTransaction()
    transaction?.replace(container, fragment)
    transaction?.disallowAddToBackStack()
    transaction?.commit()
}

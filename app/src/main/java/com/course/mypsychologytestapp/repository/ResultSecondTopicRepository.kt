package com.course.mypsychologytestapp.repository

import com.course.mypsychologytestapp.model.ResultSecondTopic
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ResultSecondTopicRepository {
    fun createResultSecondTest(resultSecondTopic: ResultSecondTopic) {
        val database = Firebase.database
        val userDbRef = database.getReference("Topic Two")
        val userNodeRef = userDbRef.child(resultSecondTopic.uid)
        userNodeRef.setValue(resultSecondTopic)
    }
}
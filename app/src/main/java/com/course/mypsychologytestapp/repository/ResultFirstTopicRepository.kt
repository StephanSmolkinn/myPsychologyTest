package com.course.mypsychologytestapp.repository

import com.course.mypsychologytestapp.model.ResultFirstTopic
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ResultFirstTopicRepository {
    fun createResultFirstTopic(resultFistTopic: ResultFirstTopic) {
        val database = Firebase.database
        val userDbRef = database.getReference("Topic One")
        val userNodeRef = userDbRef.child(resultFistTopic.uid)
        userNodeRef.setValue(resultFistTopic)
    }
}
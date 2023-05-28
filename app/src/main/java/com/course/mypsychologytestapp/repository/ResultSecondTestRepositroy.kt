package com.course.mypsychologytestapp.repository

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ResultSecondTestRepository {
    fun createResultSecondTest(resultSecondTest: ResultSecondTest) {
        val database = Firebase.database
        val userDbRef = database.getReference("Test Two")
        val userNodeRef = userDbRef.child(resultSecondTest.uid)
        userNodeRef.setValue(resultSecondTest)
    }
}
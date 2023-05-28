package com.course.mypsychologytestapp.repository

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ResultFirstTestRepository {
    fun createResultFirstTest(resultFistTest: ResultFistTest) {
        val database = Firebase.database
        val userDbRef = database.getReference("Test One")
        val userNodeRef = userDbRef.child(resultFistTest.uid)
        userNodeRef.setValue(resultFistTest)
    }
}
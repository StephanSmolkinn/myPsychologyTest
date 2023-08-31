package com.course.mypsychologytestapp.repository

import com.course.mypsychologytestapp.model.ResultFirstTest
import com.course.mypsychologytestapp.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ResultFirstTestRepository {
    fun createResultFirstTest(resultFistTest: ResultFirstTest) {
        val database = Firebase.database
        val userDbRef = database.getReference("Test One")
        val userNodeRef = userDbRef.child(resultFistTest.uid)
        userNodeRef.setValue(resultFistTest)
    }
}

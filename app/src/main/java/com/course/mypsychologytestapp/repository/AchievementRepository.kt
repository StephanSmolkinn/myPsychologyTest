package com.course.mypsychologytestapp.repository


import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class AchievementRepository {

    fun createAchievement(achievement: Achievement) {
        val database = Firebase.database
        val userDbRef = database.getReference("achievement")
        val userNodeRef = userDbRef.child(achievement.uid)
        userNodeRef.setValue(achievement)
    }

}

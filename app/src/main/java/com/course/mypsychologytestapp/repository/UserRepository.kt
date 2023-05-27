package com.course.mypsychologytestapp.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class UserRepository {

    fun createUser(user: User) {
        val database = Firebase.database
        val userDbRef = database.getReference("users")
        val userNodeRef = userDbRef.child(user.uid)
        userNodeRef.setValue(user)
    }

    interface GetUserListener {
        fun onGetUser(user: User)
    }

    fun getUser(firebaseUser: FirebaseUser, userListener: GetUserListener) {
        val database = Firebase.database
        val userDbRef = database.getReference("users")
        userDbRef.child(firebaseUser.uid).addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue<User>() ?: mapFromFirebaseUser(FirebaseAuth.getInstance().currentUser!!)
                    userListener.onGetUser(user)
                }

                override fun onCancelled(error: DatabaseError) {
                    val user = mapFromFirebaseUser(FirebaseAuth.getInstance().currentUser!!)
                    userListener.onGetUser(user)
                }
            }
        )
    }

}

fun mapFromFirebaseUser(user: FirebaseUser) =
    User(user.uid, user.displayName ?: "no name user", user.photoUrl.toString())
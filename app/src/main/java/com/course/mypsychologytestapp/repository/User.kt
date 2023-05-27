package com.course.mypsychologytestapp.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val uid: String = "",
    val displayName: String = "",
    var photo: String? = ""
) : Parcelable
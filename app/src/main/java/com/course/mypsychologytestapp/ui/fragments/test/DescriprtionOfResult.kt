package com.course.mypsychologytestapp.ui.fragments.test

fun checkResult(resultTest: String): String {
    return when (resultTest) {
        // for test one
        "Phlegmatic" -> "Phlegmatic"
        "Choleric" -> "Choleric"
        "Sanguine" ->  "Sanguine"
        "Melancholic" -> "Melancholic"

        // for test two
        "Introvert" -> "Introvert"
        "Extrovert" -> "Extrovert"

        else -> ""
    }
}

fun descriptionFirstTest(number: Int): String {
    return when (number) {
        1 -> "Phlegmatic person loves dogs"
        2 -> "Choleric person loves cats"
        3 -> "Sanguine person loves flowers"
        4 -> "Melancholic person no one love"

        else -> ""
    }
}

fun descriptionSecondTest(number: Int): String {
    return when (number) {
        1 -> "Introvert loves dog"
        2 -> "Extrovert loves cat"

        else -> ""
    }
}

fun getDescriptionFirstTest(resultTest: String): String {
    return when (resultTest) {
        "Phlegmatic" -> return descriptionFirstTest(1)
        "Choleric" -> return descriptionFirstTest(2)
        "Sanguine" -> return descriptionFirstTest(3)
        "Melancholic" -> return descriptionFirstTest(4)

        else -> ""
    }
}

fun getDescriptionSecondTest(resultTest: String): String {
    return when (resultTest) {
        "Introvert" -> return descriptionSecondTest(1)
        "Extrovert" -> return descriptionSecondTest(2)

        else -> ""
    }
}
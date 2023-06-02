package com.course.mypsychologytestapp.ui.fragments.test.description

import com.course.mypsychologytestapp.ui.fragments.test.questions.constants.ConstantsResultTest

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
        1 -> ConstantsResultTest.RESULT_PHLEGMATIC

        2 -> ConstantsResultTest.RESULT_CHOLERIC

        3 -> ConstantsResultTest.RESULT_SANGUINE

        4 -> ConstantsResultTest.RESULT_MELANCHOLIC

        else -> ""
    }
}

fun descriptionSecondTest(number: Int): String {
    return when (number) {
        1 -> ConstantsResultTest.RESULT_INTROVERT

        2 -> ConstantsResultTest.RESULT_EXTROVERT

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
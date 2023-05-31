package com.course.mypsychologytestapp.ui.fragments.test.description


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
        1 -> "Slow, difficult to switch from one activity to another, " +
                "stable and constant in aspirations and mood, " +
                "stingy with the manifestation of emotions."

        2 -> "fast, impetuous, impulsive, unbalanced, prone to sudden changes in mood, " +
                "emotional outbursts."

        3 -> "Agile, lively, easily experiencing failures, striving for a change of impressions."

        4 -> "Restrained, vulnerable, impressionable, prone to constant experience " +
                "of even minor events, shy."

        else -> ""
    }
}

fun descriptionSecondTest(number: Int): String {
    return when (number) {
        1 -> "Introverts are not too talkative, they are more silent, " +
                "but if you find the right contact with them, then " +
                "representatives of this type of personality can tell a lot of interesting things."

        2 -> "Extroverts are quite sociable and can easily find a language with a new person. " +
                "In the team, these people are the soul of the company, " +
                "they often communicate on various topics."

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
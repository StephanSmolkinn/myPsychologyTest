package com.course.mypsychologytestapp.ui.fragments.test.questions.constants

import com.course.mypsychologytestapp.ui.fragments.test.questions.Question

object ConstantsTestTwo {

    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val questionOne = Question(
            1,
            "How do you prefer to spend your free time?",
            "One on one with yourself",
            "In a small group of close friends",
            "In large groups, at events or with several groups of people",
            "In an energetic and lively environment with many people"
        )

        val questionTwo = Question(
            2,
            "How do you get energy?",
            "From inner thoughts and solitude",
            "From communication and interaction with friends",
            "From social events and emotions of people around",
            "From the activity and stimulation of the external environment"
        )

        val questionThree = Question(
            3,
            "How do you react to new situations or unexpected changes?",
            "I prefer planning and predictability",
            "Feel comfortable with change and ready to adapt",
            "Excitement and interest in new situations",
            "Feel alive and energized during change"
        )

        val questionFour = Question(
            4,
            "How do you usually show your emotions?",
            "Tends to hide his emotions and keep them to himself",
            "I talk with close people about my emotions",
            "I openly express my emotions and often show my feelings",
            "I react emotionally to events and express my feelings"
        )

        val questionFive = Question(
            5,
            "How do you prefer to process information?",
            "Spend time analyzing and thinking about information on my own",
            "Discussing ideas and getting feedback from other people",
            "I prefer group discussions and communication for information processing",
            "Make decisions quickly and act on first impressions"
        )

        val endTest = Question(
            6,
            "",
            "",
            "",
            "",
            ""
        )

        questionList.add(questionOne)
        questionList.add(questionTwo)
        questionList.add(questionThree)
        questionList.add(questionFour)
        questionList.add(questionFive)
        questionList.add(endTest)

        return questionList
    }

}
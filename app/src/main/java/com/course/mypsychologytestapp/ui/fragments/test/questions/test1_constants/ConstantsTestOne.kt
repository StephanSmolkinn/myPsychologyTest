package com.course.mypsychologytestapp.ui.fragments.test.questions.test1_constants

import com.course.mypsychologytestapp.ui.fragments.test.questions.Question

object ConstantsTestOne {

    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val questionOne = Question(
            1,
            "Question OneONE",
            "Option One",
            "Option Two",
            "Option Three",
            "Option Four"
        )

        val questionTwo = Question(
            2,
            "Question Two",
            "Option One",
            "Option Two",
            "Option Three",
            "Option Four"
        )

        val questionThree = Question(
            3,
            "Question Three",
            "Option One",
            "Option Two",
            "Option Three",
            "Option Four"
        )

        val questionFour = Question(
            4,
            "Question Four",
            "Option One",
            "Option Two",
            "Option Three",
            "Option Four"
        )

        val questionFive = Question(
            5,
            "Question Five",
            "Option One",
            "Option Two",
            "Option Three",
            "Option Four"
        )

        val questionSix = Question(
            6,
            "Question Six",
            "Option One",
            "Option Two",
            "Option Three",
            "Option Four"
        )

        val endTest = Question(
            7,
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
        questionList.add(questionSix)
        questionList.add(endTest)

        return questionList
    }

}
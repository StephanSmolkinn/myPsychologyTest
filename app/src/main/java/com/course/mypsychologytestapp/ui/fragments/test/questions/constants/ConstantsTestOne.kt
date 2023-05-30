package com.course.mypsychologytestapp.ui.fragments.test.questions.constants

import com.course.mypsychologytestapp.ui.fragments.test.questions.Question

object ConstantsTestOne {

    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val questionOne = Question(
            1,
            "How often do you show emotions?",
            "Rarely or almost never",
            "Often and intensely",
            "Often, but not too intensely",
            "Spontaneously, but with reduced intensity"
        )

        val questionTwo = Question(
            2,
            "How do you react to changes in plans?",
            "I calmly adapt to new circumstances ",
            "I quickly worry and try to find a solution ",
            "I accept changes with optimism and interest",
            "I feel uncomfortable and prefer to stay with my plans"
        )

        val questionThree = Question(
            3,
            "How do you prefer to spend your free time?",
            "In a calm environment, doing your favorite hobbies",
            "In active movement and sports",
            "In the company of friends or new acquaintances",
            "In solitude, plunging into reflections"
        )

        val questionFour = Question(
            4,
            "How do you respond to new and unexpected challenges?",
            "I assess the situation and plan actions ",
            "I accept the challenge and immediately proceed to action",
            "Get excited and start discussing ideas with others",
            "Nervous and prefer to avoid such situations"
        )

        val questionFive = Question(
            5,
            "How do you usually react to criticism?",
            "I accept criticism calmly and analyze it",
            "I defend my point of view and argue my actions",
            "I laugh and answer with jokes",
            "I perceive criticism with sadness and regret"
        )

        val questionSix = Question(
            6,
            "How do you feel about risks and new adventures?",
            "I prefer to avoid risk and carefully make decisions",
            "Ready to take risks in order to achieve the goal",
            "I have a positive attitude towards new opportunities",
            "I feel anxiety and uncertainty when changing the usual regimen"
        )

        val questionSeven = Question(
            7,
            "How do you react to unexpected changes in plans?",
            "I quickly adapt and look for alternative options",
            "I get annoyed and try to return everything to its previous state",
            "I accept new changes and look for opportunities in a new situation",
            "I feel strong discomfort and strive for stability"
        )

        val questionEight = Question(
            8,
            "How do you prefer to organize your workspace?",
            "Clean and tidy, everything is in its place",
            "Functionally, so that it is convenient and efficient to work ",
            "With photographs, souvenirs and other elements",
            "With personal items that help me focus"
        )

        val endTest = Question(
            9,
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
        questionList.add(questionSeven)
        questionList.add(questionEight)
        questionList.add(endTest)

        return questionList
    }

}
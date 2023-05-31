package com.course.mypsychologytestapp.ui.fragments.topic.constants

object ConstantsTopic {

    fun getTextTopicOne(number: Int): String {
        val textList = ArrayList<String>()

        val textPageOne = "A person with a sanguine temperament " +
                "is always easy-going and appreciates the support of friends. " +
                "The sanguine is always ready for adventure and is inspired by the environment."

        val textPageTwo = "fast, impulsive, impulsive, unbalanced, prone to sudden mood swings, " +
                "emotional outbursts. Choleric has a huge capacity for work." +
                "They are quite stress-resistant and like to overcome difficulties."

        val textPageThree = "slow, difficult to switch from one activity to another, " +
                "stable and constant in aspirations and mood, stingy with the manifestation of emotions." +
                "The most stable type of temperament. In most cases, they are in a calm and even mood. " +
                "They are stable and balanced."

        val textPageFour = "restrained, vulnerable, impressionable, " +
                "prone to constant experience of even minor events, shy." +
                "Melancholics are often in a passive mood, more shy than other types of temperament. " +
                "They are more difficult to tolerate any changes in life or work."

        textList.add(textPageOne)
        textList.add(textPageTwo)
        textList.add(textPageThree)
        textList.add(textPageFour)

        return textList.get(number)
    }

    fun getTextTopicTwo(number: Int): String {
        val textList = ArrayList<String>()

        val textPageOne = "An introvert is a type of person who focuses on their inner world, " +
                "and only a little on the outside. Despite their lack of sociability, " +
                "introverts can be very pleasant and interesting interlocutors, " +
                "if you communicate with them correctly on topics of interest to them."

        val textPageTwo = "An extrovert is a person who is open to the world and directed " +
                "towards people. When talking, an extrovert looks into the interlocutor's " +
                "eyes without looking away. An extrovert can have a rich inner world."

        textList.add(textPageOne)
        textList.add(textPageTwo)

        return textList.get(number)
    }

}
package com.course.mypsychologytestapp.ui.fragments.topic.constants

// topic one
const val TOPIC_ONE_TEXT_PAGE_ONE = "A person with a sanguine temperament " +
        "is always easy-going and appreciates the support of friends. " +
        "The sanguine is always ready for adventure and is inspired by the environment."

const val TOPIC_ONE_TEXT_PAGE_TWO = "fast, impulsive, impulsive, unbalanced, prone to sudden mood swings, " +
        "emotional outbursts. Choleric has a huge capacity for work." +
        "They are quite stress-resistant and like to overcome difficulties."

const val TOPIC_ONE_TEXT_PAGE_THREE = "slow, difficult to switch from one activity to another, " +
        "stable and constant in aspirations and mood, stingy with the manifestation of emotions." +
        "The most stable type of temperament. In most cases, they are in a calm and even mood. " +
        "They are stable and balanced."

const val TOPIC_ONE_TEXT_PAGE_FOUR = "restrained, vulnerable, impressionable, " +
        "prone to constant experience of even minor events, shy." +
        "Melancholics are often in a passive mood, more shy than other types of temperament. " +
        "They are more difficult to tolerate any changes in life or work."

// topic two
const val TOPIC_TWO_TEXT_PAGE_ONE  = "An introvert is a type of person who focuses on their inner world, " +
        "and only a little on the outside. Despite their lack of sociability, " +
        "introverts can be very pleasant and interesting interlocutors, " +
        "if you communicate with them correctly on topics of interest to them."

const val TOPIC_TWO_TEXT_PAGE_TWO = "An extrovert is a person who is open to the world and directed " +
        "towards people. When talking, an extrovert looks into the interlocutor's " +
        "eyes without looking away. An extrovert can have a rich inner world."

object ConstantsTopic {

    fun getTextTopicOne(number: Int): String {
        val textList = ArrayList<String>()

        textList.add(TOPIC_ONE_TEXT_PAGE_ONE)
        textList.add(TOPIC_ONE_TEXT_PAGE_TWO)
        textList.add(TOPIC_ONE_TEXT_PAGE_THREE)
        textList.add(TOPIC_ONE_TEXT_PAGE_FOUR)

        return textList.get(number)
    }

    fun getTextTopicTwo(number: Int): String {
        val textList = ArrayList<String>()

        textList.add(TOPIC_TWO_TEXT_PAGE_ONE)
        textList.add(TOPIC_TWO_TEXT_PAGE_TWO)

        return textList.get(number)
    }

}
package com.course.mypsychologytestapp.ui.fragments.test.process

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentTestProcessBinding
import com.course.mypsychologytestapp.model.ResultSecondTest
import com.course.mypsychologytestapp.repository.*
import com.course.mypsychologytestapp.ui.fragments.test.questions.Question
import com.course.mypsychologytestapp.ui.fragments.test.questions.constants.ConstantsTestTwo
import com.course.mypsychologytestapp.ui.fragments.test.result.TestSecondResultFragment
import com.google.firebase.auth.FirebaseAuth

class TestTwoProcessFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentTestProcessBinding
    lateinit var questionListTest1: ArrayList<Question>
    private var selectedAnswer: Int = 0
    private var currentPosition: Int = 1
    private var balls: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestProcessBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        questionListTest1 = ConstantsTestTwo.getQuestion()

        binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)
        binding.submitQuestionButton.setOnClickListener(this)

        setQuestion()
    }

    private fun setQuestion() {
        var question: Question = questionListTest1[currentPosition - 1]

        binding.question.text = question.question
        binding.optionOne.text = question.optionOne
        binding.optionTwo.text = question.optionTwo
        binding.optionThree.text = question.optionThree
        binding.optionFour.text = question.optionFour

        binding.progressBar.max = 5
        binding.progressBar.progress = currentPosition
        binding.progressTextView.text = "$currentPosition/${binding.progressBar.max}"
        textViewAppearance()

        if (currentPosition == questionListTest1.size - 1)
            binding.submitQuestionButton.text = "Finish"
        else
            binding.submitQuestionButton.text = "SUBMIT"
    }

    private fun textViewAppearance() {
        val options = ArrayList<TextView>()
        options.add(0, binding.optionOne)
        options.add(1, binding.optionTwo)
        options.add(2, binding.optionThree)
        options.add(3, binding.optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#03A9F4"))
            option.typeface = Typeface.DEFAULT
            option.background = context?.let {
                ContextCompat.getDrawable(it, R.drawable.option_background)
            }
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.optionOne -> selectedOption(binding.optionOne, 1)
            R.id.optionTwo -> selectedOption(binding.optionTwo, 2)
            R.id.optionThree -> selectedOption(binding.optionThree, 3)
            R.id.optionFour -> selectedOption(binding.optionFour, 4)
            R.id.submitQuestionButton -> {
                if (selectedAnswer != 0 && currentPosition < questionListTest1.size) {
                    getBalls(selectedAnswer)
                    currentPosition++
                    if (currentPosition == questionListTest1.size) {
                        updateResultTestTwo()
                        val transaction = activity?.supportFragmentManager?.beginTransaction()
                        transaction?.replace(R.id.containerTest, TestSecondResultFragment())
                        transaction?.disallowAddToBackStack()
                        transaction?.commit()
                    }
                    else {
                        val question = questionListTest1[currentPosition - 1]
                        setQuestion()
                    }
                }
                else if (selectedAnswer == 0) {
                    when {
                        currentPosition <= questionListTest1.size -> {
                            Toast.makeText(requireContext(), "Choose option", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(requireContext(), "Test finished", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                selectedAnswer = 0
            }
        }
    }

    private fun selectedOption(textView: TextView, selectedPosition: Int) {
        textViewAppearance()
        selectedAnswer = selectedPosition
        textView.setTextColor(Color.parseColor("#FF3700B3"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = context?.let {
            ContextCompat.getDrawable(it, R.drawable.option_background)
        }
    }

    private fun getBalls(selectedAnswer: Int) {
        when(selectedAnswer) {
            1 -> balls++
            2 -> balls += 2
            3 -> balls += 3
            4 -> balls += 4
        }
    }

    private fun updateResultTestTwo() {
        updateDatabase(balls)
    }

    private fun updateDatabase(resultBalls: Int) {
        val resultSecondTest = ResultSecondTest(
            uid = FirebaseAuth.getInstance().currentUser!!.uid,
            result = resultPersonality(resultBalls)
        )
        ResultSecondTestRepository().createResultSecondTest(resultSecondTest)
    }

    private fun resultPersonality(resultBalls: Int): String {
        return when (resultBalls) {
            in 5..12 -> "Introvert"
            in 13..20 -> "Extrovert"

            else -> ""
        }
    }

}
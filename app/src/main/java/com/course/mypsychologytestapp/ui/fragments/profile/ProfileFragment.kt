package com.course.mypsychologytestapp.ui.fragments.profile

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.course.mypsychologytestapp.R
import com.course.mypsychologytestapp.databinding.FragmentProfileBinding
import com.course.mypsychologytestapp.repository.User
import com.course.mypsychologytestapp.repository.UserRepository
import com.course.mypsychologytestapp.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.squareup.picasso.Picasso

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val repository = UserRepository()
    private lateinit var currentUser: User
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        FirebaseAuth.getInstance().currentUser?.let {
            binding.progressBar.isVisible = true
            repository.getUser(it, object : UserRepository.GetUserListener {
                override fun onGetUser(user: User) {
                    currentUser = user
                    showInfo(currentUser, it)
                }
            })
        }

        binding.signOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        binding.nameTextInputLayout.setEndIconOnClickListener {
            updateName()
        }

        binding.emailTextInputLayout.setEndIconOnClickListener {
            val user = FirebaseAuth.getInstance().currentUser
            val email = binding.editEmail.text.toString()
            if (checkEmailField()) {
                FirebaseAuth.getInstance().currentUser?.updateEmail(email)?.addOnCompleteListener {
                    if (it.isSuccessful)
                        Toast.makeText(requireContext(), "Email updated", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun updateName() {
        if (TextUtils.isEmpty(binding.editName.text)) {
            binding.editName.error = "Empty"
            return
        }

        val request = UserProfileChangeRequest.Builder()
            .setDisplayName(binding.editName.text.toString())
            .build()

        FirebaseAuth.getInstance().currentUser?.updateProfile(request)?.addOnCompleteListener {
            if (it.isSuccessful) {
                updateDatabaseUser()
            }
        }
    }

    private fun checkEmailField(): Boolean {
        val email = binding.editEmail.text.toString()

        if (binding.editEmail.text.toString().isEmpty()) {
            binding.emailTextInputLayout.error = "Empty"
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailTextInputLayout.error = "Invalid email format"
            return false
        }

        return true
    }

    private fun updateDatabaseUser() {
        val user = User(
            displayName = binding.editName.text.toString(),
            uid = FirebaseAuth.getInstance().currentUser!!.uid,
            photo = FirebaseAuth.getInstance().currentUser?.photoUrl.toString()
        )

        UserRepository().createUser(user)
    }

    private fun showInfo(currentUser: User, it: FirebaseUser) {
        binding.editName.setText(currentUser.displayName)
        binding.editEmail.setText(it.email)

        currentUser.photo?.let {
            if (it.isNotEmpty()) {
                Picasso.get().load(it).placeholder(R.drawable.ic_account_box)
                    .into(binding.userImage)
            }
        }

        binding.progressBar.isVisible = false
    }

}
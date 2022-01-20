package com.android.pacenow.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.pacenow.base.BaseFragment
import com.android.pacenow.databinding.FragmentLoginBinding
import com.android.pacenow.view.dashboard.activity.DashboardActivity
import com.android.pacenow.view.viewmodel.LoginFragmentViewModel

class LoginFragment : BaseFragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val loginFragmentViewModel: LoginFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (preferenceHelper.isLogIn()) {
            startActivity(Intent(requireActivity(), DashboardActivity::class.java))
            requireActivity().finish()
        }
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservert()
        binding.buttonLogin.setOnClickListener {
            loginFragmentViewModel.validateUser(binding.usernameEditText.text.toString(),binding.passwordEditText.text.toString())
        }

    }

    fun initObservert () {
        loginFragmentViewModel.errorResponse().observe(viewLifecycleOwner,  {
            binding.loginUsernameEditText.error = "UserName is required"
            binding.loginPasswordEditText.error = "Password is required"
        })
        loginFragmentViewModel.successResponse().observe(viewLifecycleOwner, Observer {
            binding.usernameEditText.error = null
            binding.passwordEditText.error = null
            preferenceHelper.setIsLogIn(true)
            startActivity(Intent(activity, DashboardActivity::class.java))
            activity?.finish()
        })
    }


}
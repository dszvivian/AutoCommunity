package com.example.autocommunity.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.autocommunity.R;

public class SignupFragment extends Fragment {

    AppCompatButton btnSignUp;
    TextView tvNavigateToSinIn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSignUp = view.findViewById(R.id.btnSignUp);
        tvNavigateToSinIn = view.findViewById(R.id.tvNavigateToSignIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(requireActivity(),R.id.fragmentAuth)
                        .navigate(R.id.action_signupFragment_to_mainActivity);

            }
        });

        tvNavigateToSinIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireActivity(),R.id.fragmentAuth)
                        .navigate(R.id.action_signupFragment_to_signinFragment2);
            }
        });





    }
}

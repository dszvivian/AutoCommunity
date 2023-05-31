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

public class SigninFragment extends Fragment {

    AppCompatButton btnSignIn;
    TextView tvNavigateToSinUp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signin,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSignIn = view.findViewById(R.id.btnSignIn);
        tvNavigateToSinUp = view.findViewById(R.id.tvNavigateToSignUp);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(requireActivity(),R.id.fragmentAuth)
                        .navigate(R.id.action_signinFragment_to_mainActivity);

            }
        });

        //If you don't Have a Account
        tvNavigateToSinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireActivity(),R.id.fragmentAuth)
                        .navigate(R.id.action_signinFragment_to_signupFragment2);
            }
        });


    }
}

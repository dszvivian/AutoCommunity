package com.example.autocommunity.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import com.example.autocommunity.ApiViewModel;
import com.example.autocommunity.R;
import com.example.autocommunity.model.User;

public class SignupFragment extends Fragment {

    EditText etUsername,etEmail,etPassword;
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
        etUsername = view.findViewById(R.id.etNameSignUp);
        etEmail = view.findViewById(R.id.etEmailSignUp);
        etPassword = view.findViewById(R.id.etPasswordSignUp);
        tvNavigateToSinIn = view.findViewById(R.id.tvNavigateToSignIn);

        tvNavigateToSinIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireActivity(),R.id.fragmentAuth)
                        .navigate(R.id.action_signupFragment_to_signinFragment2);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiViewModel vm = new ApiViewModel();

                String username = etUsername.getText().toString() ;
                String email = etEmail.getText().toString() ;
                String password = etPassword.getText().toString();

                if(!(username.isEmpty() && email.isEmpty() && password.isEmpty())){
                    vm.addNewUser(new User(username,email,password)).observe(requireActivity(), new Observer<Boolean>() {
                        @Override
                        public void onChanged(Boolean isUserAdded) {
                            if(isUserAdded){
                                Toast.makeText(requireActivity(),"New User Added",Toast.LENGTH_SHORT).show();
                                requireActivity().finish();
                                Navigation.findNavController(requireActivity(),R.id.fragmentAuth)
                                        .navigate(R.id.action_signupFragment_to_mainActivity);
                            }else{
                                Toast.makeText(requireActivity(),"Authentication Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(requireActivity(),"Some Fields are Empty",Toast.LENGTH_SHORT).show();
                }






            }
        });



    }
}

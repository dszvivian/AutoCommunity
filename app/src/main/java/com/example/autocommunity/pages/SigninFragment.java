package com.example.autocommunity.pages;

import android.content.Intent;
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
import com.example.autocommunity.Preferences;
import com.example.autocommunity.R;
import com.example.autocommunity.activities.MainActivity;
import com.example.autocommunity.model.User;

import java.util.List;

public class SigninFragment extends Fragment {

    AppCompatButton btnSignIn;
    TextView tvNavigateToSinUp;
    EditText etEmail,etPassword;

    Preferences pf;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signin,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etEmail = view.findViewById(R.id.etUsernameSignIn);
        etPassword = view.findViewById(R.id.etPasswordSignIn);
        btnSignIn = view.findViewById(R.id.btnSignIn);
        tvNavigateToSinUp = view.findViewById(R.id.tvNavigateToSignUp);


        pf = new Preferences();
        String username = pf.isLoggedIn(requireActivity());
        if(!username.isEmpty()){
            startActivity(new Intent(requireActivity(), MainActivity.class));
        }


        //If you don't Have a Account
        tvNavigateToSinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireActivity(),R.id.fragmentAuth)
                        .navigate(R.id.action_signinFragment_to_signupFragment2);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiViewModel vm = new ApiViewModel();

                String username = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(!(username.isEmpty() && password.isEmpty())){

                    vm.getUser(username).observe(requireActivity(), new Observer<List<User>>() {
                        @Override
                        public void onChanged(List<User> users) {

                            User user = users.get(0);

                            if(user.getPassword().equals(password)){
                                Toast.makeText(requireActivity(),"SignIn Successful",Toast.LENGTH_SHORT).show();
                                pf.saveData(requireActivity(),username);
                                requireActivity().finish();
                                Navigation.findNavController(requireActivity(),R.id.fragmentAuth)
                                        .navigate(R.id.action_signinFragment_to_mainActivity);
                                System.out.print(user.getUsername()+user.getPassword());
                            }else{
                                etPassword.setText("");
                                Toast.makeText(requireActivity(),"Incorrect Password",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    Toast.makeText(requireActivity(),"Some Fields Are Empty",Toast.LENGTH_SHORT).show();
                }
                        }
                    });


    }
}

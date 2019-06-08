package com.rja.login.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.rja.login.R;
import com.rja.login.ui.main.MainActivity;

import org.w3c.dom.Text;

public class LoginFragment extends Fragment {

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextInputEditText usernameView = view.findViewById(R.id.username_edit_text);
        TextInputEditText passwordView = view.findViewById(R.id.password_edit_text);
        MaterialButton loginButton = view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidateUsernameAndPassword(usernameView,passwordView)){
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                    onLogin();
                }
                else{
                    Toast.makeText(getContext(), "failure", Toast. LENGTH_SHORT).show();
                }
            }

        });

    }
    private boolean ValidateUsernameAndPassword(TextInputEditText username, TextInputEditText password){
        String usernameText= username.getText().toString();
        String passwordText= password.getText().toString();
        if (passwordText.length() < 3){
            password.setError("PASSWORD NOT LONG ENOUGH");
            return false;
        }
        if (usernameText.length()<2){
            username.setError("USERNAME NOT LONG ENOUGH");
            return false;

        }

        return true;

    }

    private void onLogin() {
        startActivity(MainActivity.createIntent(getContext()));
    }

}

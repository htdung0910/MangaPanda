package com.SE1310T5Pro.bookreaderapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.SE1310T5Pro.bookreaderapp.API.LoginService.LognAPI;
import com.SE1310T5Pro.bookreaderapp.API.Model.User;
import com.SE1310T5Pro.bookreaderapp.API.Retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    LoginFragment(){

    }
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        final EditText username = v.findViewById(R.id.user_id);
        final EditText password = v.findViewById(R.id.password_id);
        final Button btn = v.findViewById(R.id.login_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                LognAPI login = RetrofitConfig.getRetrofitInstance().create(LognAPI.class);
                String getUsername = username.getText().toString();
                String getPassword = password.getText().toString();
                Call<User> call_user = login.checkLogin(getUsername, getPassword);
                call_user.enqueue(new Callback<User>() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()){
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame, new HomeFragment()).commit();

                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        TextView fail_login = getActivity().findViewById(R.id.fail_id_login);
                        fail_login.setText("Username or Password incorrect"+t.getMessage());
                    }
                });
            }
        });
        return v;
    }

}

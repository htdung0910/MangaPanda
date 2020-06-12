package com.SE1310T5Pro.bookreaderapp;

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

import com.SE1310T5Pro.bookreaderapp.API.LoginService.LoginAPI;
import com.SE1310T5Pro.bookreaderapp.API.Model.User;
import com.SE1310T5Pro.bookreaderapp.API.Retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    LoginFragment(){

    }

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
        Button btn = v.findViewById(R.id.login_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginAPI login = RetrofitConfig.getRetrofitInstance().create(LoginAPI.class);
                String x = username.getText().toString();
                String y = password.getText().toString();
                Call<User> call_user = login.checkLogin(x, y);
                call_user.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()){
                            TextView sucess_login = getActivity().findViewById(R.id.fail_id_login);
                            sucess_login.setText("Successful");
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

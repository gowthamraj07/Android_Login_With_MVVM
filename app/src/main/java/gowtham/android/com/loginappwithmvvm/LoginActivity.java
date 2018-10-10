package gowtham.android.com.loginappwithmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import gowtham.android.com.loginappwithmvvm.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private TextView tvUserIdError;
    private TextView tvPasswordError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvUserIdError = findViewById(R.id.tv_user_id_error_message);
        tvPasswordError = findViewById(R.id.tv_password_error_message);
        final EditText etUserId = findViewById(R.id.et_user_id);
        final EditText etPassword = findViewById(R.id.et_password);

        LoginViewModel viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        viewModel.initialize();

        viewModel.userIdError.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                tvUserIdError.setVisibility(aBoolean?View.VISIBLE:View.GONE);
            }
        });

        viewModel.passwordError.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                tvPasswordError.setVisibility(aBoolean?View.VISIBLE:View.GONE);
            }
        });

        viewModel.validationStatus.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                String message = aBoolean ? "Valid Credential" : "Invalid Credential";
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.signIn(etUserId.getText().toString(), etPassword.getText().toString());
            }
        });
    }
}

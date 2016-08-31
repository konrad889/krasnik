package tomczyk.konrad.krasnik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tomczyk.konrad.krasnik.models.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public ViewHolder layout;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    public static class ViewHolder {

        EditText mEtUsername, mEtPassword;
        Button mBtnLogin, mBtnRegister;
        Toolbar toolbar;

        public ViewHolder(View root) {
            mEtUsername = (EditText) root.findViewById(R.id.login_et_fragment_user_name);
            mEtPassword = (EditText) root.findViewById(R.id.login_fragment_user_password);
            mBtnLogin = (Button) root.findViewById(R.id.login_btn_fragment_user_login);
            mBtnRegister = (Button) root.findViewById(R.id.login_btn_fragment_user_register);
            toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setElementClicable();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            onAuthSuccess(mAuth.getCurrentUser());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    private boolean validateForm() {
        boolean result = true;
        if (TextUtils.isEmpty(layout.mEtUsername.getText().toString())) {
            layout.mEtUsername.setError("Required");
            result = false;
        } else {
            layout.mEtUsername.setError(null);
        }

        if (TextUtils.isEmpty(layout.mEtPassword.getText().toString())) {
            layout.mEtPassword.setError("Required");
            result = false;
        } else {
            layout.mEtPassword.setError(null);
        }

        return result;
    }

    private void signIn() {
        if (!validateForm()) {
            return;
        }
        String userName = layout.mEtUsername.getText().toString();
        String userPassword = layout.mEtPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(userName, userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            onAuthSuccess(task.getResult().getUser());
                        } else {
                            Toast.makeText(MainActivity.this, "Sign In Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void signUp() {
        if (!validateForm()) {
            String userName = layout.mEtUsername.getText().toString();
            String userPassword = layout.mEtPassword.getText().toString();
            mAuth.createUserWithEmailAndPassword(userName, userPassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                onAuthSuccess(task.getResult().getUser());
                            } else {
                                Toast.makeText(MainActivity.this, "Sign up Failed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void onAuthSuccess(FirebaseUser user) {
        String username = usernameFromEmail(user.getEmail());
        writeNewUser(user.getUid(), username, user.getEmail());
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

    private void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);
        mDatabase.child("users").child(userId).setValue(user);
    }

    private void setElementClicable() {
        layout.mBtnRegister.setOnClickListener(onClick);
        layout.mBtnLogin.setOnClickListener(onClick);
    }

    private View.OnClickListener onClick;

    {
        onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == layout.mBtnLogin) {
                    signIn();
                } else if (v == layout.mBtnRegister) {
                    signUp();
                }
            }
        };
    }

    public Toolbar getToolbar() {
        return layout.toolbar;
    }

}

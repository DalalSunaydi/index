package com.next.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPass;
    private MaterialButton materialButton;
    private FloatingActionButton floatingActionButton;

    private void initUI(){

        textInputEditTextEmail=findViewById(R.id.edtSignUpEmail);
        textInputEditTextPass=findViewById(R.id.edtSignUpPassword);
        materialButton=findViewById(R.id.btnSignUp);
        floatingActionButton=findViewById(R.id.fab);

    }

    private void newUserSignin(){
        String userEmail=textInputEditTextEmail.getText().toString();
        String userPassword=textInputEditTextPass.getText().toString();

        if (userEmail.isEmpty()){

            textInputEditTextEmail.setError("error");
            textInputEditTextEmail.requestFocus();
            return;

        }

        if (userPassword.isEmpty()){

            textInputEditTextPass.setError("error");
            textInputEditTextPass.requestFocus();
            return;

        }

        mAuth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "SigninUserWithEmail:success");
                            String user_id = mAuth.getCurrentUser().getUid();

                            finish();
                            startActivity(new Intent(getBaseContext(),MainActivity.class));

//                            finish();
//                            startActivity(new Intent(getBaseContext(),DonorMainActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initUI();

        mAuth = FirebaseAuth.getInstance();



        //sign in a new user
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("buttun","clicked sign in");
                newUserSignin();
            }
        });



        //back button
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}
package com.example.lajukantin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
//    TextView tvRegister;
    private EditText loginEmail, loginPassword;
    private TextView signupRedirectText;
    private Button loginButton;
    private FirebaseAuth auth;
    TextView forgotPassword;
//    GoogleSignInButton googleBtn;
//    GoogleSignInOptions gOptions;
//    GoogleSignInClient gClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

//        tvRegister = findViewById(R.id.tvRegister);
        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        signupRedirectText = findViewById(R.id.signUpRedirectText);
        forgotPassword = findViewById(R.id.forgot_password);
//        googleBtn = findViewById(R.id.googleBtn);
        auth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText().toString();
                String pass = loginPassword.getText().toString();
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(SignInActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignInActivity.this, HomeActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(SignInActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        loginPassword.setError("Empty fields are not allowed");
                    }
                } else if (email.isEmpty()) {
                    loginEmail.setError("Empty fields are not allowed");
                } else {
                    loginEmail.setError("Please enter correct email");
                }
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            }
        });

//        forgotPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);
//                EditText emailBox = dialogView.findViewById(R.id.emailBox);
//                builder.setView(dialogView);
//                AlertDialog dialog = builder.create();
//                dialogView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        String userEmail = emailBox.getText().toString();
//                        if (TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
//                            Toast.makeText(LoginActivity.this, "Enter your registered email id", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                        auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()){
//                                    Toast.makeText(LoginActivity.this, "Check your email", Toast.LENGTH_SHORT).show();
//                                    dialog.dismiss();
//                                } else {
//                                    Toast.makeText(LoginActivity.this, "Unable to send, failed", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//                    }
//                });
//                dialogView.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });
//                if (dialog.getWindow() != null){
//                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
//                }
//                dialog.show();
//            }
//        });
//        //Inside onCreate
//        gOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//        gClient = GoogleSignIn.getClient(this, gOptions);
//        GoogleSignInAccount gAccount = GoogleSignIn.getLastSignedInAccount(this);
//        if (gAccount != null){
//            finish();
//            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(intent);
//        }
//        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//                        if (result.getResultCode() == Activity.RESULT_OK){
//                            Intent data = result.getData();
//                            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//                            try {
//                                task.getResult(ApiException.class);
//                                finish();
//                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                startActivity(intent);
//                            } catch (ApiException e){
//                                Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//                });
//        googleBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent signInIntent = gClient.getSignInIntent();
//                activityResultLauncher.launch(signInIntent);
//            }
//        });

//        signupRedirectText.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Intent intent1 = new Intent(SignInActivity.this, SignUpActivity.class);
//                startActivity(intent1);
//            }
//        });
    }
}
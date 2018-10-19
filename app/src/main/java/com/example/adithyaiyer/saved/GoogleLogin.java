package com.example.adithyaiyer.saved;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class GoogleLogin extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    SignInButton button;
    FirebaseAuth mAuth;
    private final static int RC_SIGN_IN = 2;
    GoogleSignInOptions gso;

    private String personName;
    private String personEmailID;
    private String personID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);
        button = (SignInButton) findViewById(R.id.google_sign_in);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        personEmailID = "Default ID";
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

        if (acct != null) {
            personName = acct.getDisplayName();
            personEmailID = acct.getEmail();
            personID = acct.getId();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        Toast.makeText(this, "already signed in", Toast.LENGTH_SHORT).show();
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

        if (acct != null) {
            personName = acct.getDisplayName();
            personEmailID = acct.getEmail();
            personID = acct.getId();
            Intent go = new Intent(getApplicationContext(), MainActivity.class);
            go.putExtra("emailIdCustomer", personEmailID);
            go.putExtra("nameCustomer", personName);
            go.putExtra("IDcustomer", personID);
            startActivity(go);
        }

        Toast.makeText(this, "hi " + personName, Toast.LENGTH_SHORT).show();
        updateUI(account);


    }

    private void updateUI(GoogleSignInAccount account) {
        Toast.makeText(this, "ho gaya sign in", Toast.LENGTH_SHORT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            updateUI(null);
        }
    }


    public void signIn() {

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
        Toast.makeText(this,"You are now a member, please Log In",Toast.LENGTH_SHORT).show();
    }
    public void goToActivity(View view){

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
       // Toast.makeText(this, "already signed in", Toast.LENGTH_SHORT).show();
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

        if (acct != null) {
            personName = acct.getDisplayName();
            personEmailID = acct.getEmail();
            personID = acct.getId();
            Intent go = new Intent(getApplicationContext(), MainActivity.class);
            go.putExtra("emailIdCustomer", personEmailID);
            go.putExtra("nameCustomer", personName);
            go.putExtra("IDcustomer", personID);
            startActivity(go);
        }

    }




}

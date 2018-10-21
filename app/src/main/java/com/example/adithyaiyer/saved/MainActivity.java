package com.example.adithyaiyer.saved;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String nameOfPerson;
    private String emailOfPerson;
    private String idOfPerson;
    GoogleSignInClient mGoogleSignInClient;
    GoogleSignInOptions gso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //  TextView name = (TextView) findViewById(R.id.nameDisplayedOnDrawer);
        //   TextView email = (TextView) findV;
        // iewById(R.id.emailIDDesplayedOnDrawer);

        Bundle b = getIntent().getExtras();
        nameOfPerson = b.getString("nameCustomer");
        emailOfPerson = b.getString("emailIdCustomer");
        idOfPerson = b.getString("IDcustomer");

        Bundle data = new Bundle();
        data.putString("key_value", "String to pass");


        NavigationView navigationView2 = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView2.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nameDisplayedOnDrawer);
        TextView navEmail = (TextView) headerView.findViewById(R.id.emailIDDesplayedOnDrawer);

        navEmail.setText(emailOfPerson);
        navUsername.setText(nameOfPerson);

        NavigationView navigationView3 = (NavigationView) findViewById(R.id.action_settings);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Bundle b = getIntent().getExtras();
        nameOfPerson = b.getString("nameCustomer");
        emailOfPerson = b.getString("emailIdCustomer");
        idOfPerson = b.getString("IDcustomer");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        android.support.v4.app.Fragment f =null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();
      
        if (id == R.id.emergency) {
        f = new Emergency_fragment();


        } else if (id == R.id.profile) {
            f = new Profile();

        } else if (id == R.id.Favourites) {

        } else if (id == R.id.search) {

        }else if(id==R.id.helplines){

        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.emergencyFragment,f);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
        Intent i = new Intent(this,GoogleLogin.class);
        startActivity(i);
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public String getEmailOfPerson() {
        return emailOfPerson;
    }

    public String getIdOfPerson() {
        return idOfPerson;
    }
}

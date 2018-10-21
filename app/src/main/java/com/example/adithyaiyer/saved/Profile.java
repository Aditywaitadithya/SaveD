package com.example.adithyaiyer.saved;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Profile extends android.support.v4.app.Fragment {


    private EditText phone;
    private EditText fav1;
    private EditText fav2;
    private EditText fav3;
    private EditText blood;
    private EditText med;
    private String email;
    private String name;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_layout,null);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        phone = (EditText)view.findViewById(R.id.phone);
        fav1 = (EditText)view.findViewById(R.id.fav1);
        fav2 = (EditText)view.findViewById(R.id.fav2);
        fav3 = (EditText)view.findViewById(R.id.fav3);
        blood = (EditText)view.findViewById(R.id.blood);
        med = (EditText)view.findViewById(R.id.med);
        MainActivity mainAct = (MainActivity)getActivity();
        email = mainAct.getEmailOfPerson();
        name = mainAct.getNameOfPerson();
        Button saveProfile = (Button) view.findViewById(R.id.saveProfile);
        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfile();
            }
        });







    }
    private void updateProfile(){
        customer customerProfileEdited= new customer(name,email,phone.getText().toString(),fav1.getText().toString(),fav2.getText().toString(),fav3.getText().toString(),blood.getText().toString(),med.getText().toString());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServiceCustomer.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        ApiServiceCustomer api= retrofit.create(ApiServiceCustomer.class);
        Call<customer> changeCustomerProfile=api.updateCustomer(email,customerProfileEdited);

        changeCustomerProfile.enqueue(new Callback<customer>() {
            @Override
            public void onResponse(Call<customer> call, Response<customer> response) {
                Toast.makeText(getActivity(),"Profile Successfully Updated",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<customer> call, Throwable t) {
                Toast.makeText(getActivity(),"Profile update unsuccessful, check internet connectivity",Toast.LENGTH_SHORT).show();

            }
        });
    }


}

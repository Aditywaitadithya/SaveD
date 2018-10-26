package com.example.adithyaiyer.saved;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Emergency_fragment extends android.support.v4.app.Fragment {
        public Button yesButton;
        public Button NoButton;
        public TextView disName;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.emergency_layout,null);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        yesButton = (Button)view.findViewById(R.id.yesButton);

        NoButton = (Button)view.findViewById(R.id.noButton);

        disName = (TextView)view.findViewById(R.id.DisasterName);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServiceCustomer.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        ApiServiceCustomer api= retrofit.create(ApiServiceCustomer.class);
        MainActivity mainAct = (MainActivity)getActivity();
        Call<customer> call=api.getCustomer(mainAct.getEmailOfPerson());
        call.enqueue(new Callback<customer>() {
            @Override
            public void onResponse(Call<customer> call, Response<customer> response) {
                if(response.body()!=null){
                disName.setText(response.body().getLocation_lat().toString());}
            }

            @Override
            public void onFailure(Call<customer> call, Throwable t) {

            }
        });

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                markMeSafe();
            }
        });

        NoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                markMeUnsafe();
            }
        });


    }

    public void markMeSafe(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServiceCustomer.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        ApiServiceCustomer api= retrofit.create(ApiServiceCustomer.class);
        MainActivity mainAct = (MainActivity)getActivity();

        Call<List<customer>> call=api.markMeSafe(mainAct.getEmailOfPerson());
        call.enqueue(new Callback<List<customer>>() {
            @Override
            public void onResponse(Call<List<customer>> call, Response<List<customer>> response) {
              //  Toast.makeText(getActivity(),"You have been marked safe !",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<customer>> call, Throwable t) {
                //Toast.makeText(getActivity(),"Check Your Internet Connection ",Toast.LENGTH_SHORT).show();;
            }
        });

    }

    public void markMeUnsafe(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServiceCustomer.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        ApiServiceCustomer api= retrofit.create(ApiServiceCustomer.class);
        MainActivity mainAct = (MainActivity)getActivity();

        Call<List<customer>> call=api.markMeUnSafe(mainAct.getEmailOfPerson());
        call.enqueue(new Callback<List<customer>>() {
            @Override
            public void onResponse(Call<List<customer>> call, Response<List<customer>> response) {
               // Toast.makeText(getActivity(),"The authorities will be notified that you are unsafe !",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<customer>> call, Throwable t) {
               // Toast.makeText(getActivity(),"Check Your Internet Connection ",Toast.LENGTH_SHORT).show();;

            }
        });
    }

}

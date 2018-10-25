package com.example.adithyaiyer.saved;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Favourites extends android.support.v4.app.Fragment {
    private Context thiscontext;
    private customerAdapter mAdapter;
    private List<customer> favList;
    private RecyclerView fav;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        this.thiscontext = getActivity().getApplicationContext();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        thiscontext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        thiscontext = container.getContext();

        return inflater.inflate(R.layout.fav_layout,null);

    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServiceCustomer.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        ApiServiceCustomer api= retrofit.create(ApiServiceCustomer.class);
        MainActivity mainAct = (MainActivity)getActivity();

        Call<List<customer>> call=api.getMyCustomerFavs(mainAct.getEmailOfPerson());
        fav = (RecyclerView)view.findViewById(R.id.customerRecyclerView);

        call.enqueue(new Callback<List<customer>>() {
            @Override
            public void onResponse(Call<List<customer>> call, Response<List<customer>> response) {
                favList = response.body();
                Toast.makeText(thiscontext,favList.get(1).getEmail_id().toString(),Toast.LENGTH_SHORT).show();
                 mAdapter = new customerAdapter(favList ,thiscontext);
                fav.setAdapter(mAdapter);
                RecyclerView.LayoutManager eLayoutManager3 = new LinearLayoutManager(getActivity().getApplicationContext());
                fav.setLayoutManager(eLayoutManager3);
                fav.setItemAnimator(new DefaultItemAnimator());

            }

            @Override
            public void onFailure(Call<List<customer>> call, Throwable t) {
                Toast.makeText(thiscontext,"check your internet connection",Toast.LENGTH_SHORT).show();
            }
        });

    }


}

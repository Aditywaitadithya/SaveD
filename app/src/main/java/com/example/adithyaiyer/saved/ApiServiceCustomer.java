package com.example.adithyaiyer.saved;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiServiceCustomer {

    public static final String ROOT_URL = "http://10.196.18.62:8000/";

    @GET("customers/")
    Call<List<customer>> getMyJSONCustomer();

    @PUT("customers/{emailId}/")
    Call<customer> updateCustomer(@Path("emailId") String id, @Body customer c);


}

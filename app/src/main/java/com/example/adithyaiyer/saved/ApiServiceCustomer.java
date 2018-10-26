package com.example.adithyaiyer.saved;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiServiceCustomer {

    public static final String ROOT_URL = "http://192.168.1.102:8000/";

    @GET("customers/{emailId}")
    Call<customer> getCustomer(@Path("emailId") String id);

    @GET("customers/")
    Call<List<customer>> getMyJSONCustomer();

    @PUT("customers/{emailId}/")
    Call<customer> updateCustomer(@Path("emailId") String id, @Body customer c);

    @GET("customers/favs/{emailId}")
    Call<List<customer>> getMyCustomerFavs(@Path("emailId") String id);

    @GET("customers/search/{emailId}")
    Call<List<customer>> getMySearchResults(@Path("emailId") String id);

    @GET("customers/markSafe/{emailId}")
    Call<List<customer>> markMeSafe(@Path("emailId") String id);

    @GET("customers/markUnsafe/{emailId}")
    Call<List<customer>> markMeUnSafe(@Path("emailId") String id);

}

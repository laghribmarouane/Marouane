package com.example.authentificationapp.network;

import com.example.authentificationapp.model.AuthentificationModel;
import com.example.authentificationapp.model.Root;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface
{
    @GET(Constants.LOGIN_ENDPOINT)
    Call<AuthentificationModel> sendAuthRequest();
    @GET(Constants.GET_ITEMS_ENDPOINT)
    Call<Root> getItems();




}

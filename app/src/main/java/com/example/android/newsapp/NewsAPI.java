package com.example.android.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsAPI {

    @GET("search?q=debates&api-key=81f793a6-6670-4ada-8b25-db4c155c567d")
    Call<Data> getNews();

}

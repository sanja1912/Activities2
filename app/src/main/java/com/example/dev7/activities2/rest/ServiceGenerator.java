package com.example.dev7.activities2.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dev7 on 11.12.17..
 */

public class ServiceGenerator {
    private static final String baseUrl="http://api.themoviedb.org/3/";
    public static final String API_KEY="a0cce257672d7bda0b2483231292f85e";
    private MovieApiService movieApiService;
    private static Retrofit retrofit;
    private OkHttpClient client;

}

package com.accenture.pocproject.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fjodors.pohodnevs on 8/26/2016.
 */
public class PocApiClient {

    public static final String API_GET_BASE_URL = "http://###READERIP###/";
    public static final String API_POST_BASE_URL = "http://###WRITERIP###/";

    private static final String API_KEY_HEADER = "API-KEY";
    private static final String API_KEY = "123";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String CONTENT_TYPE = "application/json";

    private static Retrofit retrofitGet = null;
    private static Retrofit retrofitPost = null;

    private static OkHttpClient getOkHttpClient() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader(API_KEY_HEADER, API_KEY)
                        .addHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE)
                        .build();
                return chain.proceed(newRequest);
            }
        };

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor)
                .addInterceptor(loggingInterceptor);
        return builder.build();
    }

    //Use Multiple retrofit clients(GET and POST), because we have different end points for each.
    public static Retrofit getGetClient() {
        if (retrofitGet == null) {
            retrofitGet = new Retrofit.Builder()
                    .baseUrl(API_GET_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofitGet;
    }

    public static Retrofit getPostClient() {
        if (retrofitPost == null) {
            retrofitPost = new Retrofit.Builder()
                    .baseUrl(API_POST_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofitPost;
    }

}

package com.example.bizzmovies.Apis;




import androidx.databinding.library.baseAdapters.BuildConfig;

import com.example.bizzmovies.Util.AppConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.bizzmovies.Util.AppConstants.BASE_URL;


public class APIClient implements AppConstants {

    public static APIInterface getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getRetrofitClient())
                .build();

        return retrofit.create(APIInterface.class);
    }

    private static OkHttpClient getRetrofitClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.readTimeout(60, TimeUnit.SECONDS);
        client.connectTimeout(60, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG)
            client.addInterceptor(logging);
        return client.build();
    }
}

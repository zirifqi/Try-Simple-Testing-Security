package id.go.rembangkab.ngetest.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import id.go.rembangkab.ngetest.services.URLs;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getProfile() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URLs.URL_LOAD_DASHBOARD)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getDashboard() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URLs.URL_LOAD_DASHBOARD)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static final String BASE_URL_KU = "https://sim.rembangkab.go.id/njempol2018/mobile/lab/";

//    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_KU)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }


    public static Retrofit getSignature() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_KU)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

package com.mgilangjanuar.dev.ssoui;

import com.mgilangjanuar.dev.ssoui.models.AccessTokenModel;
import com.mgilangjanuar.dev.ssoui.models.UserModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

class Api {

    private static String baseUrl = Constant.BASE_URL;
    private static Retrofit adapter = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static Service create() {
        Service result = adapter.create(Service.class);
        baseUrl = Constant.BASE_URL;
        adapter = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return result;
    }

    interface Service {

        @FormUrlEncoded
        @POST("token")
        Call<AccessTokenModel> postCredential(
                @Field("grant_type") String grantType,
                @Field("client_id") String clientId,
                @Field("client_secret") String clientSecret,
                @Field("username") String username,
                @Field("password") String password
        );

        @GET("resource")
        Call<UserModel> getStudentDetail(
                @Query("access_token") String accessToken
        );

    }
}

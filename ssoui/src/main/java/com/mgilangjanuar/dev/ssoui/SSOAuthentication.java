package com.mgilangjanuar.dev.ssoui;

import android.support.annotation.NonNull;

import com.mgilangjanuar.dev.ssoui.listener.AuthListener;
import com.mgilangjanuar.dev.ssoui.models.AccessTokenModel;
import com.mgilangjanuar.dev.ssoui.models.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class SSOAuthentication {

    private static String username;
    private static String password;
    private static AuthListener listener;

    public static void login(String username, String password, AuthListener listener) {
        SSOAuthentication.username = username;
        SSOAuthentication.password = password;
        SSOAuthentication.listener = listener;
        getAccessToken();
    }

    private static void getAccessToken() {
        Api.create().postCredential(
                Constant.GRANT_TYPE,
                Constant.CLIENT_ID,
                Constant.CLIENT_SECRET,
                username, password
        ).enqueue(new Callback<AccessTokenModel>() {
            @Override
            public void onResponse(@NonNull Call<AccessTokenModel> call, @NonNull Response<AccessTokenModel> response) {
                AccessTokenModel tokenModel = response.body();
                if (tokenModel != null) {
                    getUser(tokenModel.getAccessToken());
                } else {
                    listener.onError("Username or password are wrong");
                }
            }

            @Override
            public void onFailure(@NonNull Call<AccessTokenModel> call, @NonNull Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    private static void getUser(String accessToken) {
        Api.create().getStudentDetail(accessToken).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(@NonNull Call<UserModel> call, @NonNull Response<UserModel> response) {
                listener.onLogin(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<UserModel> call, @NonNull Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
}

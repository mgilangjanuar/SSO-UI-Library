package com.mgilangjanuar.dev.ssoui.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class AccessTokenModel {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("expires_in")
    private String expiresIn;

    @SerializedName("token_type")
    private String tokenType;

    private String scope;

    @SerializedName("refresh_token")
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }
}

package com.mgilangjanuar.dev.ssoui.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class UserModel {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("client_id")
    private String clientId;

    @SerializedName("token_expires")
    private String tokenExpires;

    @SerializedName("ldap_dn")
    private String ldapDn;

    @SerializedName("ldap_sn")
    private String ldapSn;

    @SerializedName("siak_npm")
    private String siakNpm;

    @SerializedName("siak_nama")
    private String siakNama;

    @SerializedName("siak_kd_org")
    private String siakKdOrg;

    @SerializedName("siak_is_active")
    private String siakIsActive;

    public String getUsername() {
        return userId;
    }

    public String getStudentId() {
        return siakNpm;
    }

    public String getName() {
        return siakNama;
    }

    public String getFaculty() {
        return dataExtraction().get(3);
    }

    public String getRole() {
        return dataExtraction().get(1);
    }

    public boolean isActive() {
        return "TRUE".equals(siakIsActive);
    }

    private List<String> dataExtraction() {
        List<String> results = new ArrayList<>();
        for (String datum : ldapDn.split(",")) {
            String[] extract = datum.split("=");
            results.add(extract[1]);
        }
        return results;
    }
}

package com.mgilangjanuar.dev.sample.modules.auth.presenter;

import android.content.Context;
import android.text.TextUtils;

import com.mgilangjanuar.dev.sample.R;
import com.mgilangjanuar.dev.ssoui.SSOAuthentication;
import com.mgilangjanuar.dev.ssoui.listener.AuthListener;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class LoginPresenter {

    private Context context;
    private AuthListener listener;

    public LoginPresenter(Context context, AuthListener listener) {
        this.context = context;
        this.listener = listener;
    }

    private boolean validate(String... credentials) {
        for (String credential : credentials) {
            if (TextUtils.isEmpty(credential)) {
                return false;
            }
        }
        return true;
    }

    public void login(String username, String password) {
        if (!validate(username, password)) {
            listener.onError(context.getString(R.string.fields_cannot_be_blank));
            return;
        }

        SSOAuthentication.login(username, password, listener);
    }
}

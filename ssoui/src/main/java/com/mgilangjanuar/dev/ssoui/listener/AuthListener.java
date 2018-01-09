package com.mgilangjanuar.dev.ssoui.listener;

import com.mgilangjanuar.dev.ssoui.models.UserModel;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public interface AuthListener {

    void onError(String message);

    void onLogin(UserModel model);
}

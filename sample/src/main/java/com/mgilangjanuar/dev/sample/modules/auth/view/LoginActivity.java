package com.mgilangjanuar.dev.sample.modules.auth.view;

import android.app.ProgressDialog;
import android.widget.EditText;

import com.mgilangjanuar.dev.sample.R;
import com.mgilangjanuar.dev.sample.base.BaseActivity;
import com.mgilangjanuar.dev.sample.modules.auth.presenter.LoginPresenter;
import com.mgilangjanuar.dev.ssoui.listener.AuthListener;
import com.mgilangjanuar.dev.ssoui.models.UserModel;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements AuthListener {

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.password)
    EditText password;

    private ProgressDialog progressDialog;
    private LoginPresenter presenter = new LoginPresenter(this, this);

    @Override
    public int findLayout() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.login_button)
    public void login() {
        hideKeyboard();
        progressDialog = createProgressDialog(R.string.loading);
        progressDialog.show();
        presenter.login(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void onError(String error) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
        showSnackbar(error);
    }

    @Override
    public void onLogin(UserModel model) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
        showToast(model.getName() + "\n" +
                model.getStudentId() + "\n" +
                model.getUsername() + "\n" +
                model.getFaculty() + "\n" +
                model.getRole() + "\n" +
                String.valueOf(model.isActive()));
    }
}

package com.octagonproject.octagon;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.octagonproject.octagon.utils.AppPreferences;
import com.octagonproject.octagon.utils.Config;
import com.octagonproject.octagon.utils.FBLoginClass;
import com.octagonproject.octagon.utils.HTTPUrlConnection;
import com.octagonproject.octagon.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SignupActivity extends BaseActivity implements FBLoginClass.OnFBResultListener{
    private FBLoginClass fbLoginClass;
    private String username, password,email,displayname,fname,lname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fbLoginClass = new FBLoginClass();
        fbLoginClass.sdkInitialize(this);
        findViewById(R.id.img_back).setOnClickListener(this);
        findViewById(R.id.btn_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_login_fb).setOnClickListener(this);
        findViewById(R.id.btn_reg_fb).setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btn_sign_in:
                username = ((EditText) findViewById(R.id.txt_login_email)).getText().toString().trim();
                if (username.isEmpty()) {
                    ((EditText) findViewById(R.id.txt_login_email)).setError(getString(R.string.error_username_empty));
                    break;
                }
                password = ((EditText) findViewById(R.id.txt_login_password)).getText().toString().trim();
                if (password.isEmpty()) {
                    ((EditText) findViewById(R.id.txt_login_password)).setError(getString(R.string.error_password_empty));
                    break;
                }
                if (Utils.isNetworkConnected(this, true)) {
                    new SignInTask().execute();
                }
                break;
            case R.id.btn_reg_fb:
            case R.id.btn_login_fb:
                fbLoginClass.setFBResultListener(this);
                fbLoginClass.sdkInitialize(getApplicationContext());
                fbLoginClass.login(this);
                break;
            case R.id.btn_register:
                fname = ((EditText) findViewById(R.id.txt_reg_fname)).getText().toString().trim();
                if (fname.isEmpty()) {
                    ((EditText) findViewById(R.id.txt_reg_fname)).setError("Please enter first name");
                    break;
                }
                lname = ((EditText) findViewById(R.id.txt_reg_lname)).getText().toString().trim();
                if (lname.isEmpty()) {
                    ((EditText) findViewById(R.id.txt_reg_lname)).setError("Please enter last name");
                    break;
                }
                email = ((EditText) findViewById(R.id.txt_reg_email)).getText().toString().trim();
                if (email.isEmpty()) {
                    ((EditText) findViewById(R.id.txt_reg_email)).setError("Please enter email address");
                    break;
                }
                username = ((EditText) findViewById(R.id.txt_reg_username)).getText().toString().trim();
                if (username.isEmpty()) {
                    ((EditText) findViewById(R.id.txt_reg_username)).setError(getString(R.string.error_username_empty));
                    break;
                }
                password = ((EditText) findViewById(R.id.txt_reg_password)).getText().toString().trim();
                if (password.isEmpty()) {
                    ((EditText) findViewById(R.id.txt_reg_password)).setError(getString(R.string.error_password_empty));
                    break;
                }
                if (Utils.isNetworkConnected(this, true)) {
                    new GetNonce().execute();
                }
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fbLoginClass.callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onStop() {
        super.onStop();
        fbLoginClass.stopTracking();
    }


    @Override
    public void onFBResult(JSONObject object) {
        Log.v(TAG, object.toString());
        try {
            if (Utils.isNetworkConnected(this, true)) {
                username = object.getString("name");
                new SocialLogin().execute(object.getString("token"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SocialLogin extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgessDialog();
        }

        @Override
        protected String doInBackground(String... params) {

            return HTTPUrlConnection.getInstance().loadGet(Config.SOCIAL_LOGIN + "&access_token=" + params[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dismissProgressDialog();
            try {
                JSONObject object = new JSONObject(result);
                if (object.getString("status").equalsIgnoreCase("ok")) {
                    AppPreferences pref = AppPreferences.getAppPreferences(getApplicationContext());
                    pref.putStringValue(AppPreferences.USER_NAME, username);

                    finish();
                } else {
                    Toast.makeText(SignupActivity.this, object.getString("error"), Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

    class SignInTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgessDialog();
        }

        @Override
        protected String doInBackground(String... params) {

            return HTTPUrlConnection.getInstance().loadGet(Config.LOGIN + "&email=" + username + "&password=" + password);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dismissProgressDialog();
            try {
                JSONObject object = new JSONObject(result);
                if (object.getString("status").equalsIgnoreCase("ok")) {
                    JSONObject data = object.getJSONObject("user");
                    AppPreferences pref = AppPreferences.getAppPreferences(getApplicationContext());
                    pref.putStringValue(AppPreferences.USER_ID, data.getString("id"));
                    pref.putStringValue(AppPreferences.USER_NAME, data.getString("username"));
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finishAffinity();
                } else {
                    Toast.makeText(SignupActivity.this, object.getString("error"), Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

    class GetNonce extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgessDialog();
        }

        @Override
        protected String doInBackground(String... params) {

            return HTTPUrlConnection.getInstance().loadGet(Config.NONCE);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dismissProgressDialog();
            try {
                JSONObject object = new JSONObject(result);
                if (object.getString("status").equalsIgnoreCase("ok")) {
                    new SignUpTask().execute(object.getString("nonce"));
                } else {
                    Toast.makeText(SignupActivity.this, object.getString("error"), Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
    class SignUpTask extends AsyncTask<String, Void, String> {
        HashMap<String, String> postDataParams;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgessDialog();
        }

        @Override
        protected String doInBackground(String... params) {

            return HTTPUrlConnection.getInstance().loadGet(Config.REGISTER + "&username="+username+"&email="+email+"&nonce="+params[0]+
                    "&display_name="+username+"&user_pass="+password+"&firstname="+fname+"&lastname="+lname);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dismissProgressDialog();
            try {
                JSONObject object = new JSONObject(result);
                if (object.getString("status").equalsIgnoreCase("ok")) {
                    //JSONObject data = object.getJSONObject("user");
                    AppPreferences pref = AppPreferences.getAppPreferences(getApplicationContext());
                    pref.putStringValue(AppPreferences.USER_ID, object.getString("user_id"));
                    pref.putStringValue(AppPreferences.USER_NAME, username);
                    finish();
                } else {
                    Toast.makeText(SignupActivity.this, object.getString("error"), Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}

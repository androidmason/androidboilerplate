package com.androidmason.androidlogin;

import android.content.Context;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;
import java.util.List;

/**
 * This class is used to handle all configurations required for authentication using facebook.
 * It also handles callbacks received after authentication.
 *
 * Created by monilshah on 28/10/15.
 */
public class FacebookLogin {

    private Context context;

    public FacebookLogin(Context context){
        this.context = context;

        // Initializing facebook sdk
        FacebookSdk.sdkInitialize(context);
    }

    public void initialize(LoginButton fbLoginBtn, CallbackManager callbackManager){

        // Setting permissions for fetching facebook content and performing facebook actions (eg: posting on facebook)
        List<String> facebookPermissions= Arrays.asList("user_photos", "email", "user_birthday", "user_friends" , "read_custom_friendlists");
        fbLoginBtn.setReadPermissions(facebookPermissions);

        // Callback registration
        fbLoginBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}

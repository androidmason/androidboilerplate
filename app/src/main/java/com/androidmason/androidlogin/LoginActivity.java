package com.androidmason.androidlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

/**
 * Handles User Authentication.
 *
 * Created by monilshah on 28/10/15.
 */
public class LoginActivity extends Activity {

    private LoginButton fbLoginBtn;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Facebook sdk initialization
        FacebookLogin fbLogin = new FacebookLogin(getBaseContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_login);

        initializeWidgets();

        // initialize fb button
        fbLogin.initialize(fbLoginBtn, callbackManager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeWidgets(){
        fbLoginBtn = (LoginButton) findViewById(R.id.login_button);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,
                resultCode, data);
    }

}

package com.sharedprefrence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by Techno Blogger on 29/4/16.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText _userName;
    private Button _button;
    public static final String PREFS_NAME = "LoginPrefs";
    private String inputUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _userName = (EditText) findViewById(R.id.edt_username);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getString("logged", "").toString().equals("logged")) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

        _button = (Button) findViewById(R.id.button);
        _button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputUser = _userName.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MyName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("UserName", inputUser);
                editor.apply();
                Log.e("Input is : ", inputUser);

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor1 = settings.edit();
                editor1.putString("logged", "logged");
                editor1.apply();

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

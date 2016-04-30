package com.sharedprefrence;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Techno Blogger on 29/4/16.
 */
public class HomeActivity extends Activity {

    String _myContact;
    TextView _textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPref =  getSharedPreferences("MyName", Context.MODE_PRIVATE);
        _myContact = sharedPref.getString("UserName", "");

        _textView = (TextView) findViewById(R.id.textView);
        _textView.setText(_myContact);
    }
}

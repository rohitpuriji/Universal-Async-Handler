package com.tech.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tech.universalasynchandler.AppLogs;
import com.tech.universalasynchandler.HttpPostCaller;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpPostCaller httpPostCaller = new HttpPostCaller();
        Object responseObject = httpPostCaller.getResponse(MainActivity.this,"https://api.androidhive.info/contacts/",new JSONObject(),"Please wait....");
        if (responseObject instanceof  String){
            AppLogs.printLogs("response :",responseObject.toString());
        }
    }
}

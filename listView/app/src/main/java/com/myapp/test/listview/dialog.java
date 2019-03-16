package com.myapp.test.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Intent intent = getIntent();
if (intent!=null){
    String texttoput = intent.getStringExtra("CountryName");
        TextView tv = findViewById(R.id.textView2);
        Log.d("statusofapp","omg > "+texttoput);
        tv.setText(texttoput);
    }
    }

    public void closeDialog(View v){

        finish();
    }
}

package com.example.user.work3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        b1 = (Button)findViewById(R.id.content1);
        b2 = (Button)findViewById(R.id.content2);
    }

    public void onClick(View v){
        Intent intent;
        if(v.getId() == R.id.content1){
            intent = new Intent(StartActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.content2){
            intent = new Intent(StartActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    }
}

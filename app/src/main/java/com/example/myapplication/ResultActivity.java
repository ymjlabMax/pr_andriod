package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent i = getIntent();
        String result = i.getStringExtra("result");

//        TextView resultView = findViewById(R.id.result);
//        resultView.setText(result);

        ((TextView) findViewById(R.id.result)).setText(result);

        /*계산기 화면으로 돌아가기*/



        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainPage = new Intent();

                Log.d("되돌아가기", "onClick: back");
                startActivity(mainPage);
            }
        });



    }
}
package com.example.myapplication;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView editResult;
    TextView addResult;

    String histroy;
    String num1;
    String num2;
    double d1;
    double d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editResult = findViewById(R.id.editResult);


        findViewById(R.id.btn0).setOnClickListener(clickListener);
        findViewById(R.id.btn1).setOnClickListener(clickListener);
        findViewById(R.id.btn2).setOnClickListener(clickListener);
        findViewById(R.id.btn3).setOnClickListener(clickListener);
        findViewById(R.id.btn4).setOnClickListener(clickListener);
        findViewById(R.id.btn5).setOnClickListener(clickListener);
        findViewById(R.id.btn6).setOnClickListener(clickListener);
        findViewById(R.id.btn7).setOnClickListener(clickListener);
        findViewById(R.id.btn8).setOnClickListener(clickListener);
        findViewById(R.id.btn9).setOnClickListener(clickListener);

        /*초기화 버튼*/
        findViewById(R.id.btnAllClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResult.setText("");
                histroy = "";
                num1 = "";
                num2 = "";
            };

        });

        /*한글자씩 지우기 버튼*/
        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                histroy = editResult.getText().toString();
                num1 = histroy.substring(0, histroy.length() - 1);
                editResult.setText(num1);
            }
        });

        /* 더하기 버튼 */
        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                histroy = editResult.getText().toString();

                d1 = Double.parseDouble(editResult.getText().toString());





            }
        });
        /* 결과 화면 보내기 */
        findViewById(R.id.btnCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultPage = new Intent(MainActivity.this, ResultActivity.class);
                resultPage.putExtra("result", editResult.getText());


                startActivity(resultPage);
            }
        });


    }

    /*숫자 키 눌렀을때 값 전달*/
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            editResult.setText(editResult.getText().toString() + view.getTag().toString());

        };
    };


}

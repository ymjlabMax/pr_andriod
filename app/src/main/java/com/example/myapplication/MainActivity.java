package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    TextView editResult;
    TextView result_box;
    Button btn_result;
    Button btn_save;
    Button btn_memo;

    String histroy;
    String num1;
    String num2;
    double d1;
    double d2;

    Boolean inputYn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editResult = findViewById(R.id.editResult);
        result_box = findViewById(R.id.resultBox);
        btn_result = findViewById(R.id.btnResult);
        btn_save = findViewById(R.id.btnSave);
        btn_memo = findViewById(R.id.btnMemo);

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

                if(histroy.length() > 0){
                    num1 = histroy.substring(0, histroy.length() - 1);
                    editResult.setText(num1);
                }


            }
        });

        /* 더하기 버튼 */
        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                histroy = editResult.getText().toString();


                if(histroy.length() > 0 ){
                    d1 = Double.parseDouble(editResult.getText().toString());

                }


                Log.d("더하기", "onClick: "+ d1);


            }
        });
        /* 결과 화면 보내기 인텐트 사용해서 보내기 */
        findViewById(R.id.btnCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultPage = new Intent(MainActivity.this, ResultActivity.class);
                resultPage.putExtra("result", editResult.getText());
                startActivity(resultPage);
            }
        });


        /* resiterForActivityResult 활용 인텐트 */
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultPage = new Intent(getBaseContext(), SubActivity.class);
                launcher.launch(resultPage);
            }
        });


        /*메모장으로 이동*/
        btn_memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MemoActivity.class);
                startActivity(intent);
            }
        });

    }

    /*입력화면 전환*/
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult data) {

                    if(data.getResultCode() == Activity.RESULT_OK){
                        Intent intent = data.getData();
                        assert intent != null;
                        String result = intent.getStringExtra("result");

                        result_box.setText(result);
                    }

                }
            }
    );



    /*숫자 키 눌렀을때 값 전달*/
    View.OnClickListener clickListener = new View.OnClickListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {

                editResult.setText(editResult.getText().toString() + view.getTag().toString());

        };
    };



    public void mOnClick(View view){
        switch (view.getId()){
            case R.id.btnSave:
                String data = result_box.getText().toString();
                result_box.setText("");
                try{

                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(), "file" + ".txt" );
                    FileWriter fw = new FileWriter(file, false);
                    fw.write(data);
                    fw.close();
                    Log.d("fw", "mOnClick: fw" + file.getAbsolutePath().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }



}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MemoActivity extends AppCompatActivity {


    InputMethodManager imm;
    Button btn_internal;
    Button btn_external;
    EditText editMemo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        btn_internal = findViewById(R.id.btnInternal);
        btn_external = findViewById(R.id.btnExternal);
        editMemo = findViewById(R.id.edtMemo);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        btn_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String memo = editMemo.getText().toString();
              editMemo.setText("");
                FileOutputStream fos = null;

                    try {
                        fos = openFileOutput("internal.txt", Context.MODE_PRIVATE);
                        fos.write(memo.getBytes());
                        fos.close();
                        Log.d("인터널", "onClick: "+fos.toString());
                    } catch (IOException e){
                        e.printStackTrace();
                    }


            }
        });

    }

    /*키보드 내려오게 하기*/
    public final void hideKeyboard(View v){
        InputMethodManager var10000 = this.imm;
        if(var10000 != null){
            var10000.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

    }





}
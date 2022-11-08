package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    EditText edt_result;
    Button btn_back;
    InputMethodManager imm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edt_result = findViewById(R.id.edt_result);
        btn_back = findViewById(R.id.btn_back);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


        /*결과값 보내기*/
        btn_back.setOnClickListener(view -> {
            Intent intent = new Intent();
            String result = edt_result.getText().toString();
            intent.putExtra("result", result);
            setResult(RESULT_OK, intent);
            finish();
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
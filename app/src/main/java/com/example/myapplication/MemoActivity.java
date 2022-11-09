package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class MemoActivity extends AppCompatActivity {


    InputMethodManager imm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

    }

    /*키보드 내려오게 하기*/
    public final void hideKeyboard(View v){
        InputMethodManager var10000 = this.imm;
        if(var10000 != null){
            var10000.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

    }



}
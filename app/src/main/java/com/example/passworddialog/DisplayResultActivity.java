package com.example.passworddialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class DisplayResultActivity extends AppCompatActivity {

    private static final String TAG = "DisplayResultActivity";

    private String base = "APPLICATIONNAME                 11111111111111111111111111111111222222222222222233333333333333334444555566667777888899990000AAAABBBBCCCCDDDD10119999999999999999";
    ArrayList<byte[]> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        Intent intent = getIntent();
        boolean password = intent.getBooleanExtra("password", false);
        boolean getinfo = intent.getBooleanExtra("getinfo", false);

        ConstraintLayout cl = findViewById(R.id.cl);

        byte[] responce = base.getBytes(StandardCharsets.US_ASCII);
        ByteBuffer bb = ByteBuffer.wrap(responce);



        int[] baren = {32,32,16,16,4,4,4,4,4,4,4,4,4,4,4,2,2,16};

        for(int i = 0;i < baren.length;i++){
            byte[] dst = new byte[baren[i]];
            bb.get(dst);
            al.add(dst);
        }
        TableLayout tl = findViewById(R.id.tl);
        for (int i = 0;i < al.size();i++) {
            TableRow tr1 = new TableRow(this);
            TextView tv1 = new TextView(this);
            tv1.setText(bytesToString(al.get(i)));
            tv1.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tr1.addView(tv1);
            tl.addView(tr1);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private String bytesToString(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(byte d: bytes){
            sb.append(String.format("%02X",d));
            sb.append(" ");
        }

        return sb.toString();
    }
}
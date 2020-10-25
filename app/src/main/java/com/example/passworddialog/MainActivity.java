package com.example.passworddialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private boolean passwordCheck,getInfoCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton password = findViewById(R.id.password);
        RadioButton getInfo = findViewById(R.id.getInfo);
        Button runButton = findViewById(R.id.run);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordCheck = password.isChecked();
                getInfoCheck = getInfo.isChecked();


                Intent intent = new Intent(getBaseContext(),DisplayResultActivity.class);
                intent.putExtra("password",passwordCheck);
                intent.putExtra("getinfo",getInfoCheck);
                startActivity(intent);
            }
        });


    }
}
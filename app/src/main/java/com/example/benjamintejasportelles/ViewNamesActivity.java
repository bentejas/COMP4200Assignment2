package com.example.benjamintejasportelles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewNamesActivity extends AppCompatActivity {
    Button returnToMainButton;
    TextView nameViewText;
    Boolean isBlack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("TejasPortelles", "onCreate() method ViewNamesActivity");
        setContentView(R.layout.view_names);
        returnToMainButton = (Button) findViewById(R.id.returnButton);
        nameViewText = findViewById(R.id.textViewNames);
        nameViewText.append(getIntent().getStringExtra("addedNames"));
        isBlack = getIntent().getBooleanExtra("isBlack", false);
        if(isBlack){
            ConstraintLayout constraintLayout = findViewById(R.id.constraint_layout);
            constraintLayout.setBackgroundColor(Color.BLACK);
            TextView listTitle = findViewById(R.id.textView);
            listTitle.setTextColor(Color.WHITE);
            TextView listItems = findViewById(R.id.textViewNames);
            listItems.setTextColor(Color.WHITE);
        }
        returnToMainButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ViewNamesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TejasPortelles", "onStart() method ViewNamesActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TejasPortelles", "onStop() method ViewNamesActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TejasPortelles", "onResume() method ViewNamesActivity");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TejasPortelles", "onRestart() method ViewNamesActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TejasPortelles", "onDestroy() method ViewNamesActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TejasPortelles", "onPause() method ViewNamesActivity");
    }
}
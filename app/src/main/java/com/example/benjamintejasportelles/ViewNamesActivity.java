package com.example.benjamintejasportelles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewNamesActivity extends AppCompatActivity {
    Button returnToMainButton;
    TextView nameViewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_names);
        returnToMainButton = (Button) findViewById(R.id.returnButton);
        nameViewText = findViewById(R.id.textViewNames);
        nameViewText.append(getIntent().getStringExtra("addedNames"));
        returnToMainButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ViewNamesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
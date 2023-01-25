package com.example.benjamintejasportelles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {
    Button viewNamesButton;
    Button submitNamesButton;
    public static String currentNames = "";
    EditText currentNameText;
    CheckBox isBlack;
    private static Boolean firstName = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TejasPortelles", "onCreate() method MainActivity");
        setContentView(R.layout.activity_main);
        viewNamesButton = (Button) findViewById(R.id.viewNamesButton);
        submitNamesButton = (Button) findViewById(R.id.submitButton);
        currentNameText = (EditText) findViewById(R.id.inputText);
        isBlack = (CheckBox) findViewById(R.id.checkBox);
        // listener for transferring to view names activity button
        viewNamesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ViewNamesActivity.class);
                System.out.println(currentNames);
                intent.putExtra("addedNames", currentNames);
                intent.putExtra("isBlack", isBlack.isChecked());
                startActivity(intent);
            }
        });

        submitNamesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = currentNameText.getText().toString();
                nameAppend(name);
                currentNameText.setText("");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        createEditorActionListener();
    }

    private void createEditorActionListener() {
        currentNameText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    nameAppend(currentNameText.getText().toString());
                    currentNameText.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }
    public void nameAppend(String name){
        if(firstName){
            currentNames += name;
            firstName = false;
        }else{
            currentNames += ", " + name;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TejasPortelles", "onStart() method MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TejasPortelles", "onStop() method MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TejasPortelles", "onResume() method MainActivity");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TejasPortelles", "onRestart() method MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TejasPortelles", "onDestroy() method MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TejasPortelles", "onPause() method MainActivity");
    }
}
package com.example.appdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class shared extends AppCompatActivity {
Button applyButton, saveButton;
TextView textView;
EditText Edit;

public static final String SHARED_PREFS = "sharedPrefs";
public static final String TEXT = "text";

private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        textView = (TextView) findViewById(R.id.textView);
        Edit = (EditText)findViewById(R.id.Edit);
        applyButton = (Button)findViewById(R.id.applyButton);
        saveButton = (Button) findViewById(R.id.saveButton);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(Edit.getText().toString());
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });
        loadData();
        updateViews();

    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, textView.getText().toString());
        editor.apply();

        Toast.makeText(this, "Data saved",Toast.LENGTH_SHORT).show();

    }
    public void loadData(){
    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
    text = sharedPreferences.getString(TEXT,"");


    }
    public void updateViews(){
        textView.setText(text);
    }

}
package com.example.abdul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public  static String KEY = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View view) {
       // Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
        EditText nameEditText = findViewById(R.id.editTextName); //took handle on the edittext
        String name = nameEditText.getText().toString();        //got the string
        Intent homeIntent = new Intent(MainActivity.this,HomeActivity.class);
        homeIntent.putExtra(KEY,name);                          //inserted that string into intent
        startActivity(homeIntent);
    }
}

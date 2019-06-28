package com.example.abdul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

      String name =  getIntent().getExtras().getString(MainActivity.KEY);
        TextView nameTextView = findViewById(R.id.textViewName);
        nameTextView.setText(name);


    }
}

package com.example.abdul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CameraActivity extends AppCompatActivity {
    public static  String PHOTO = "photo";
    public  static  String TAG = CameraActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.e(TAG,"oncreate");

      String name =  getIntent().getExtras().getString(WhatsappActivity.KEY);
        TextView nameTextView = findViewById(R.id.textViewName);
        nameTextView.setText(name);


    }

    public void clickHandler(View view) {
        EditText photoEditText = findViewById(R.id.editTextPicture);
        String pixels = photoEditText.getText().toString();

        Intent resultIntent = new Intent();
        resultIntent.putExtra(PHOTO, pixels);
        Log.w(TAG,"clickHandler");

        setResult(RESULT_OK,resultIntent); //result_ok indicates the parentactivity that result is consistent
        finish(); //this will stop/finish the childactivity[Camera activity]
    }
}

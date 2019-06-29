package com.example.abdul;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WhatsappActivity extends AppCompatActivity { //AppCompatActivity will ensure  backward compatibility
    public  static String KEY = "name";
    public  static  String TAG = WhatsappActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View view) {
        switch (view.getId()){
            case R.id.buttonLogin:
                Log.i(TAG,"login button was clicked");
                EditText nameEditText = findViewById(R.id.editTextName); //took handle on the edittext
                String name = nameEditText.getText().toString();        //got the string
                Intent homeIntent = new Intent(WhatsappActivity.this, CameraActivity.class);  //explicit intent
                homeIntent.putExtra(KEY,name);                          //inserted that string into intent
                startActivityForResult(homeIntent,007); //intent, request code
                break;
            case R.id.buttonCancel:
                //implicit intent
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
                startActivity(dialIntent);
                break;
        }

       // Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 007) {
            String photo = data.getExtras().getString(CameraActivity.PHOTO);
            Toast.makeText(this, "photo", Toast.LENGTH_LONG).show();
            Log.d(TAG,"onActivityResult--"+photo);//TAG = whatsappactivity

        }
        //request -- identify which activity is returning i.e camera,contact, location
    }
}

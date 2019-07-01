package com.example.abdul;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class WhatsappActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, View.OnClickListener { //AppCompatActivity will ensure  backward compatibility
    public  static String KEY = "name";
    public  static String MY_KEY = "mykey";
    private Button loginButton;
    public  static  String TAG = WhatsappActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflating layout file -- layoutinflater

        if(savedInstanceState !=null) {
            Log.i(TAG, "mysaveddata= " + savedInstanceState.getString(MY_KEY));
        }
        Spinner languageSpinner = findViewById(R.id.spinner);
        languageSpinner.setOnItemSelectedListener(this);

        String[] countries = new String[]{"india","usa","uk"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                countries);

        ListView countriesListView = findViewById(R.id.countriesListview);
        registerForContextMenu(countriesListView);
        countriesListView.setAdapter(adapter);
        countriesListView.setOnItemClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
         loginButton = findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");

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
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.whatsappmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);

         switch (item.getItemId()){
             case R.id.locationmenuitem:
                 Toast.makeText(this, "location clicked", Toast.LENGTH_SHORT).show();
                 break;
         }

        return true;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.whatsappcontextualmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
         super.onContextItemSelected(item);
         switch (item.getItemId()){
             case R.id.editmenuitem:
                 Toast.makeText(this, "edit selected", Toast.LENGTH_SHORT).show();
                 break;
         }

        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(MY_KEY,"saved data");
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        showPopupMenu();
    }

    private void showPopupMenu(){
        PopupMenu popup = new PopupMenu(WhatsappActivity.this, loginButton);
        popup.getMenuInflater().inflate(
                R.menu.whatsappcontextualmenu, popup.getMenu());
        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        return true;
                    }
                    // implement click listener
                });
        popup.show();

    }
}

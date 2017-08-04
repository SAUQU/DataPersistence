package com.example.segundoauqui.datapersistence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String MY_PREF_FILE = "mypref_file";
    private static final String TAG= "Main";

    EditText editText1, editText2;
    TextView textView1, textView2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");


        editText1 = (EditText) findViewById(R.id.etVal1);
        editText2 = (EditText) findViewById(R.id.etVal2);

        textView1 = (TextView) findViewById(R.id.tvViewData1);
        textView2 = (TextView) findViewById(R.id.tvViewData2);



    }




    public void saveData(View view) {


        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value1", editText1.getText().toString());
        editor.putString("value2", editText2.getText().toString());
        boolean worked = editor.commit();

        if(worked){

            Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show();
        }

        else {

            Toast.makeText(this, "Unsuccessful", Toast.LENGTH_LONG).show();
        }




        }



    public void getData(View view){



        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        Log.d(TAG, "getData: " + sharedPreferences.getString("value1", "value2"));

        textView1.setText(sharedPreferences.getString("value1","Default"));
        textView2.setText(sharedPreferences.getString("value2","Default"));


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Toast.makeText(this, "Landscape",Toast.LENGTH_LONG).show();

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Toast.makeText(this, "Portrait",Toast.LENGTH_LONG).show();

    }

    public void goToNext(View view) {

        Intent intent = new Intent(this, secondActivity.class);
        startActivity(intent);

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}




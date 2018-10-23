package com.example.sonia.noteapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsPage extends AppCompatActivity {
    private SharedPreferences settingboolean;
    private SharedPreferences settingint;
    private SharedPreferences settingstring;
    private CheckBox checkBox;
    private TextView textView1;
    private TextView textView2;
    private EditText editText1;
    private EditText editText2;
    String stringmessage;
    Integer intmessage;
    boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        checkBox = (CheckBox) findViewById(R.id.settingBoolean);

        textView1 = (TextView) findViewById(R.id.settingInt);
        textView1.setText("SettingInt");
        textView2 = (TextView) findViewById(R.id.settingString);
        textView2.setText("SettingString");

        editText1 = (EditText) findViewById(R.id.editTextInt);
        editText2 = (EditText)findViewById(R.id.editTextString);

//        checked = (Boolean) checkBox.isChecked();
//        intmessage = (Integer) Integer.parseInt(editText1.getText().toString());
//        stringmessage = (String) editText2.getText().toString();

        // Get from the SharedPreferences
        settingboolean = getSharedPreferences("mySettings1", MODE_PRIVATE);
        Boolean mySetting1 = settingboolean.getBoolean("mySettings1",false);
        checkBox.setChecked(mySetting1);

        settingint = getSharedPreferences("mySettings2", MODE_PRIVATE);
        Integer mySetting2 = settingint.getInt("mySettings2", 0);
        editText1.setText(mySetting2.toString());

        settingstring = getSharedPreferences("mySettings3", MODE_PRIVATE);
        String mySetting3 = settingstring.getString("mySettings3", "something");
        editText2.setText(mySetting3);

    }

    public void homeClicked(View view){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void saveClicked(View view){
        // Write to shared preferences
        settingboolean = getSharedPreferences("mySettings1", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = settingboolean.edit();
        checked = (Boolean) checkBox.isChecked();
        editor1.putBoolean("mySettings1", checked);
        editor1.commit();

        settingint = getSharedPreferences("mySettings2", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = settingint.edit();
        intmessage = (Integer) Integer.parseInt(editText1.getText().toString());
        editor2.putInt("mySettings2", intmessage);
        editor2.commit();

        settingstring = getSharedPreferences("mySettings3", MODE_PRIVATE);
        SharedPreferences.Editor editor3 = settingstring.edit();
        stringmessage = (String) editText2.getText().toString();
        editor3.putString("mySettings3", stringmessage);
        editor3.commit();
    }


}

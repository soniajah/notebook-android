package com.example.sonia.noteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void settingsPage(View view){
        Intent intent = new Intent(this, SettingsPage.class);
        startActivity(intent);
    }

    public void createPage(View view){
        Intent intent = new Intent(this, CreateNotePage.class);
        startActivity(intent);
    }

    public void viewNotes(View view){
        Intent intent = new Intent(this, NotesPage.class);
        startActivity(intent);
    }
}

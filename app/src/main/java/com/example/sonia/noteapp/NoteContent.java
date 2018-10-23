package com.example.sonia.noteapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import static com.example.sonia.noteapp.CreateNotePage.MIGRATION_1_2;

public class NoteContent extends AppCompatActivity {
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_content);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-MyNotes").allowMainThreadQueries().addMigrations(MIGRATION_1_2).build();

        Intent intent = getIntent();
        int id = intent.getIntExtra("itemposition", 0);
        Note note = db.noteDao().getById(id);

        TextView textView = (TextView) findViewById(R.id.contentview);
        textView.setText(note.getContent());

        Date creationDate = new Date(note.getCreationdate());
        String dateAsString = creationDate.getYear() + "/" + creationDate.getMonth() + "/" + creationDate.getDate();

        TextView titleview = (TextView) findViewById(R.id.titleview);
        titleview.setText(note.getTitle());
        TextView dateview = (TextView) findViewById(R.id.dateview);
        dateview.setText(dateAsString);
    }
}

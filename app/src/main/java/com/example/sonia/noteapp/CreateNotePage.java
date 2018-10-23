package com.example.sonia.noteapp;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import java.util.List;

public class CreateNotePage extends AppCompatActivity {
    String title;
    String content;
    EditText editText1;
    EditText editText2;
//    EditText title;
//    EditText createNote;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note_page);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-MyNotes").allowMainThreadQueries().addMigrations(MIGRATION_1_2).build();

        editText1 = (EditText) findViewById(R.id.titlebox);
        editText2 = (EditText) findViewById(R.id.createNote);

    }

    public void saveNotebook(View view){
        title = editText1.getText().toString().trim();
        content = editText2.getText().toString().trim();
        Note newNote = new Note();
        newNote.setTitle(title);
        newNote.setContent(content);
        newNote.setCreationdate(new java.util.Date().getTime());

//        java.util.Date noteDate = new java.util.Date(newNote.getCreationdate());

        db.noteDao().insertAll(newNote);

        List<Note> totalnotes = db.noteDao().getAll();
        for (int i=0; i<totalnotes.size(); i++){
            Log.w("Checking", totalnotes.get(i).getTitle());
        }

        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void clearAll(View view){
        title = "";
        content="";
        editText1.setText("");
        editText2.setText("");
    }
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Since we didn't alter the table, there's nothing else to do here.
        }
    };

}

package com.example.sonia.noteapp;

import android.app.ListActivity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;


import java.util.List;

import static com.example.sonia.noteapp.CreateNotePage.MIGRATION_1_2;


public class NotesPage extends ListActivity {
    AppDatabase db;
    List<Note> allnotes;
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-MyNotes").allowMainThreadQueries().addMigrations(MIGRATION_1_2).build();

        allnotes = db.noteDao().getAll();


        String[] values = new String[allnotes.size()];
        for(int i=0; i<allnotes.size(); i++){
            values[i] = allnotes.get(i).getTitle();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Intent intent = new Intent(this, NoteContent.class);
        intent.putExtra("itemposition", allnotes.get(position).getNoteid());
        startActivity(intent);
    }


}

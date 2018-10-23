package com.example.sonia.noteapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by sonia on 11/11/2017.
 */

@Dao
public interface NoteDao {

    @Query("SELECT * FROM Note")
    List<Note> getAll();

    @Query("Select * From Note where noteid = (:noteId)")
    Note getById(int noteId);

    @Query("SELECT * FROM note WHERE noteid IN (:noteIds)")
    List<Note> loadAllByIds(int[] noteIds);

    @Query("SELECT * FROM note WHERE title LIKE :title ")
    Note findByName(String title);

    @Insert
    void insertAll(Note... notes);

    @Delete
    void delete(Note note);
}
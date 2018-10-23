package com.example.sonia.noteapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Date;


/**
 * Created by sonia on 11/11/2017.
 */

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int noteid;

    @ColumnInfo(name = "creationdate")
    private long creationdate;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "content")
    private String content;

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(long creationdate) {
        this.creationdate = creationdate;
    }


    // Getters and setters are ignored for brevity,
    // but they're required for Room to work.
}
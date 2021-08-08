package com.example.notes;

import android.os.Parcel;

import java.util.Date;

public class Note {

    private final String noteDescription;
    private final String noteName;
    private final Date createDate;

    public Note(String noteName, String noteDescription) {
        this.noteName = noteName;
        this.noteDescription = noteDescription;
        this.createDate = new Date();
    }

    protected Note(Parcel in, String noteDescription) {
        noteName = in.readString();
        this.noteDescription = noteDescription;
        createDate = new Date();
    }

    public String getNoteName() {
        return noteName;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public Date getCreateDate() {
        return createDate;
    }

}

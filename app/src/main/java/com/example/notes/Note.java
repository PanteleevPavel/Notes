package com.example.notes;

import android.os.Parcel;

import java.util.Date;

public class Note {

    private final int noteDescriptionIndex;
    private final String noteDescription;
    private final String noteName;
    private final Date createDate;

    public Note(int noteDescriptionIndex, String noteName, String noteDescription) {
        this.noteDescriptionIndex = noteDescriptionIndex;
        this.noteName = noteName;
        this.noteDescription = noteDescription;
        this.createDate = new Date();
    }

    protected Note(Parcel in, String noteDescription) {
        noteDescriptionIndex = in.readInt();
        noteName = in.readString();
        this.noteDescription = noteDescription;
        createDate = new Date();
    }

    public int getDescriptionIndex() {
        return noteDescriptionIndex;
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

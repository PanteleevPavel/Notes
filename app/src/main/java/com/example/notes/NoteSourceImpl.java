package com.example.notes;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;

public class NoteSourceImpl implements NoteSource {

    private final ArrayList<Note> notes;

    public NoteSourceImpl(Context context) {
        notes = new ArrayList<Note>(Arrays.asList(
                new Note(
                        context.getResources().getString(R.string.name1),
                        context.getResources().getString(R.string.description1)
                ),
                new Note(
                        context.getResources().getString(R.string.name2),
                        context.getResources().getString(R.string.description2)
                ),
                new Note(
                        context.getResources().getString(R.string.name3),
                        context.getResources().getString(R.string.description3)
                ),
                new Note(
                        context.getResources().getString(R.string.name4),
                        context.getResources().getString(R.string.description4)
                ),
                new Note(
                        context.getResources().getString(R.string.name5),
                        context.getResources().getString(R.string.description5)
                ))) {

        };

    }

    @Override
    public Note getNoteData(int position) {
        return notes.get(position);
    }

    @Override
    public void deleteNoteData(int position) {
        notes.remove(position);
    }

    @Override
    public void updateNoteData(int position, Note noteData) {
        notes.set(position, noteData);
    }

    @Override
    public void addNoteData(Note noteData) {
        notes.add(noteData);
    }

    @Override
    public void clearNoteData() {
        notes.clear();
    }

    @Override
    public int size() {
        return notes.size();
    }
}

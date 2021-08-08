package com.example.notes;

public interface NoteSource {

    Note getNoteData(int position);
    void deleteNoteData(int position);
    void updateNoteData(int position, Note noteData);
    void addNoteData(Note noteData);
    void clearNoteData();
    int size();
}

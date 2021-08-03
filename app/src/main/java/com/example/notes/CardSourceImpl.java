package com.example.notes;

import android.content.Context;

public class CardSourceImpl implements CardSource{

    private final Context context;
    private Note[] notes;

    public CardSourceImpl(Context context) {
        this.context = context;
        notes = new Note[] {
                new Note(
                        1,
                        context.getResources().getString(R.string.name1),
                        context.getResources().getString(R.string.description1)
                ),
                new Note(
                        2,
                        context.getResources().getString(R.string.name2),
                        context.getResources().getString(R.string.description2)
                ),
                new Note(
                        3,
                        context.getResources().getString(R.string.name3),
                        context.getResources().getString(R.string.description3)
                ),
                new Note(
                        4,
                        context.getResources().getString(R.string.name4),
                        context.getResources().getString(R.string.description4)
                ),
                new Note(
                        5,
                        context.getResources().getString(R.string.name5),
                        context.getResources().getString(R.string.description5)
                )
        };

    }

    @Override
    public Note getCardData(int position) {
        return notes[position];
    }

    @Override
    public int size() {
        return notes.length;
    }
}

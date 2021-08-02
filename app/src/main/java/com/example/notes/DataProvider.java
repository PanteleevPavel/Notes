package com.example.notes;

import android.content.res.Resources;

import androidx.annotation.NonNull;

public class DataProvider {

    public Note[] getData(@NonNull Resources resources) {
        return new Note[]{
                new Note(
                        1,
                        resources.getString(R.string.name1),
                        resources.getString(R.string.description1)
                ),
                new Note(
                        2,
                        resources.getString(R.string.name2),
                        resources.getString(R.string.description2)
                ),
                new Note(
                        3,
                        resources.getString(R.string.name3),
                        resources.getString(R.string.description3)
                ),
                new Note(
                        4,
                        resources.getString(R.string.name4),
                        resources.getString(R.string.description4)
                ),
                new Note(
                        5,
                        resources.getString(R.string.name5),
                        resources.getString(R.string.description5)
                )
        };
    }
}

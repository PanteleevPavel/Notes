package com.example.notes;

public interface CardSource {

    Note getCardData(int position);
    int size();
}

package com.example.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter adapter;
    private NoteSource noteSource;
    private RecyclerView recyclerView;
    private int currentPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        noteSource = new NoteSourceImpl(this);

        adapter = new ItemAdapter(noteSource);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        registerForContextMenu(recyclerView);

        adapter.setListener((v, position) -> {
            currentPosition = position;
            v.showContextMenu(20, 20);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cards_menu, menu);
        return true;
    }

    @SuppressLint({"NotifyDataSetChanged", "NonConstantResourceId"})
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                noteSource.addNoteData(new Note("Новая заметка", "Новое описание заметки"));
                adapter.notifyItemChanged(noteSource.size() - 1);
                recyclerView.scrollToPosition(noteSource.size() - 1);
                return true;
            case R.id.action_clear:
                noteSource.clearNoteData();
                adapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.card_menu, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_update:
                noteSource.updateNoteData(currentPosition, new Note("Изменённая заметка ", "Изменённое описание заметки"));
                adapter.notifyItemChanged(currentPosition);
                return true;
            case R.id.action_delete:
                noteSource.deleteNoteData(currentPosition);
                adapter.notifyItemRemoved(currentPosition);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
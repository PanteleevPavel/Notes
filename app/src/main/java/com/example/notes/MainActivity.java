package com.example.notes;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<String> dataSource = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        for (int i = 0; i < getResources().getStringArray(R.array.notes).length; i++) {
            dataSource.add(i, getResources().getStringArray(R.array.notes)[i]);
        }

        CardSource cardSource = new CardSourceImpl(this);

        ItemAdapter adapter = new ItemAdapter(cardSource);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setListener(position ->
                Toast.makeText(this, "AGA", Toast.LENGTH_SHORT).show());
    }
}
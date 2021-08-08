package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private final NoteSource noteSource;
    private OnItemClickListener listener;

    public ItemAdapter(NoteSource noteSource) {
        this.noteSource = noteSource;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        holder.bind(noteSource.getNoteData(position));
    }

    @Override
    public int getItemCount() {
        return noteSource.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView description;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(v, getAdapterPosition());
                }
            });
        }

        public void bind(Note note) {
            name.setText(note.getNoteName());
            description.setText(note.getNoteDescription());
        }
    }

    interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setListener(@NonNull OnItemClickListener listener) {
        this.listener = listener;
    }
}

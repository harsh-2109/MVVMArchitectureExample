package com.harsh.mvvmarchitectureexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.title_text.setText(notes.get(position).getTitle());
        holder.description_text.setText(notes.get(position).getDescription());
        holder.priority_text.setText(String.valueOf(notes.get(position).getPriority()));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        private TextView title_text;
        private TextView description_text;
        private TextView priority_text;

        NoteHolder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.title_text_view);
            description_text = itemView.findViewById(R.id.description_text_view);
            priority_text = itemView.findViewById(R.id.priority_text_view);
        }
    }
}

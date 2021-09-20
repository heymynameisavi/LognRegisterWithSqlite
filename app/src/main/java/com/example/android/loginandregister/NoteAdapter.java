package com.example.android.loginandregister;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> implements Filterable {

    Context context;
    Activity activity;
    List<NoteModel> noteModelList;
    List<NoteModel> newList;

    public NoteAdapter(Context context, Activity activity, List<NoteModel> noteModelList) {
        this.context = context;
        this.activity = activity;
        this.noteModelList = noteModelList;
        newList = new ArrayList<>(noteModelList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.title.setText(noteModelList.get(position).getTitle());
        holder.description.setText(noteModelList.get(position).getDescription());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateNotesActivity.class);
                intent.putExtra("title", noteModelList.get(position).getTitle());
                intent.putExtra("description", noteModelList.get(position).getDescription());
                intent.putExtra("id", noteModelList.get(position).getId());

                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteModelList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<NoteModel> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length()==0)
            {
                filteredList.addAll(newList);
            }
            else
            {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (NoteModel item:newList)
                {
                    if (item.getTitle().toLowerCase().contains(filterPattern))
                    {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values=filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            noteModelList.clear();
            noteModelList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, description;
        RelativeLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.note_title);
            description = itemView.findViewById(R.id.note_description);
            layout = itemView.findViewById(R.id.note_layout);
        }
    }

    public List<NoteModel> getList()
    {
        return noteModelList;
    }
    public void removeItem(int position)
    {
        noteModelList.remove(position);
        notifyItemRemoved(position);
    }
    public void restoreItem(NoteModel item, int position)
    {
        noteModelList.add(position, item);
        notifyItemInserted(position);
    }
}

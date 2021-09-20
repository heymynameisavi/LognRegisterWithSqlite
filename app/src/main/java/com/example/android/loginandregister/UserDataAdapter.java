package com.example.android.loginandregister;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.ViewHolder>{

    private ArrayList<Data> dataArrayList;
    Context context;

    public UserDataAdapter(ArrayList<Data> dataArrayList, Context context) {
        this.dataArrayList = dataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Data temp = dataArrayList.get(position);

        holder.tv_id.setText(dataArrayList.get(position).getId());
        holder.tv_email.setText(dataArrayList.get(position).getEmail());
        holder.tv_first_name.setText(dataArrayList.get(position).getFirst_name());
        holder.tv_last_name.setText(dataArrayList.get(position).getLast_name());

        Picasso.get().load(dataArrayList.get(position).getAvatar()).into(holder.tv_avatar);

        holder.tv_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailScreenActivity.class);
                intent.putExtra("imagename", temp.getAvatar());
                intent.putExtra("header", temp.getEmail());
                intent.putExtra("desc", temp.getFirst_name());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_id, tv_email, tv_first_name, tv_last_name;
        ImageView tv_avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_email = itemView.findViewById(R.id.tv_email);
            tv_first_name = itemView.findViewById(R.id.tv_first_name);
            tv_last_name = itemView.findViewById(R.id.tv_last_name);
            tv_avatar = itemView.findViewById(R.id.tv_avatar);
        }
    }
}

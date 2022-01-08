package com.example.miapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miapp.R;
import com.example.miapp.database.entitas.Kontak;

import java.util.List;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.ViewAdapter> {
    private List<Kontak> list;
    private Context context;

    public KontakAdapter(Context context, List<Kontak> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kontak, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.nama.setText(list.get(position).fullName);
        holder.no_hp.setText(list.get(position).no);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView nama, no_hp;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            no_hp = itemView.findViewById(R.id.no_hp);
        }
    }
}
package ru.rodipit.mb5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CurrViewHolder> {

    private List<Item> data;

    public MainAdapter(List<Item> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public CurrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycler_card, parent, false);

        return new CurrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getText());
        holder.imageView.setImageResource(data.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CurrViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public CurrViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.img);

        }
    }
}
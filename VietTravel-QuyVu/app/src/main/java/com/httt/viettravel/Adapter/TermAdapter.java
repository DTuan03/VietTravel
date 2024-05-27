package com.httt.viettravel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.httt.viettravel.Model.Term;
import com.httt.viettravel.R;

import java.util.ArrayList;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    ArrayList<Term> listTerm;
    Context context;

    public TermAdapter(ArrayList<Term> listTerm, Context context) {
        this.listTerm = listTerm;
        this.context = context;
    }

    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_term, parent, false);
        return new TermViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        holder.title.setText(listTerm.get(position).getTitle());
        holder.description.setText(listTerm.get(position).getDescription());

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listTerm.get(position).isVisible()){
                    holder.description.setVisibility(View.GONE);
                    listTerm.get(position).setVisible(false);
                }
                else
                {
                    holder.description.setVisibility(View.VISIBLE);
                    listTerm.get(position).setVisible(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTerm.size();
    }

    public class TermViewHolder extends RecyclerView.ViewHolder{
        TextView title, description;

        public TermViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            description = itemView.findViewById(R.id.tv_description);
        }
    }
}

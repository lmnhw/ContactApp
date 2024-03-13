package com.example.contactapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder>{
    private ArrayList<Contact> contactsList;

    public ContactsAdapter(ArrayList<Contact> contactsList) {
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(contactsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    //row item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            tvName = (TextView) view.findViewById(R.id.tv_name);
        }

    }
}

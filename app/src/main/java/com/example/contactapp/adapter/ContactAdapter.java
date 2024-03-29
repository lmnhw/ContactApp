package com.example.contactapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.contactapp.R;
import com.example.contactapp.model.Contact;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    ArrayList<Contact> contacts;
    public ContactAdapter(@NonNull Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource);
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.contact_list_items,null);
        }

        Contact contact = contacts.get(position);

        if(contact != null){
            TextView textTitle = (TextView) view.findViewById(R.id.textName);
            TextView textMobile = (TextView) view.findViewById(R.id.textNumber);

            if(textTitle != null)
                textTitle.setText(contact.getFirstName());
            if(textMobile != null)
                textMobile.setText(contact.getMobile());
        }


        return view;
    }
}

package com.example.contactapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.contactapp.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Contact> contactsList;
    private ContactsAdapter contactsAdapter;
    private AppDatabase appDatabase;
    private ContactDao contactDao;
  //  private FloatingActionButton add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mo NewCOntact
                View newContact = findViewById(R.id.newContact);
                newContact.setVisibility(View.VISIBLE);
            }
        });

        binding.rvContacts.setLayoutManager(new LinearLayoutManager(this));
        contactsList = new ArrayList<Contact>();
        contactsAdapter = new ContactsAdapter(contactsList);
        binding.rvContacts.setAdapter(contactsAdapter);

        contactsList.add(new Contact("Nguyen Van A","0913432656","a@gmail.com"));
        contactsList.add(new Contact("Le Lam Nhu","0123456789","nhu@gmail.com"));
        contactsAdapter.notifyDataSetChanged();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase = AppDatabase.getInstance(getApplicationContext());
                contactDao = appDatabase.contactDao();

                contactDao.insert(new Contact("Le Lam Nhu","0123456789","nhu@gmail.com"));

            }
        });
    }


}
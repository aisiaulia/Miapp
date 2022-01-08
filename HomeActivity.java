package com.example.miapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.miapp.adapter.KontakAdapter;
import com.example.miapp.database.AppDatabase;
import com.example.miapp.database.entitas.Kontak;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnTambah;
    private Button btnLogout;
    private AppDatabase database;
    private KontakAdapter kontakAdapter;
    private List<Kontak> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final SharePrefManager sharePrefManager = new SharePrefManager(this);

        btnLogout = findViewById(R.id.btnlogout);
        btnTambah = findViewById(R.id.btn_tambah);

        recyclerView = findViewById(R.id.rectangles);
        database = AppDatabase.getInstance(getApplicationContext());
        list.clear();
        list.addAll(database.kontakDao().getAll());
        kontakAdapter = new KontakAdapter(getApplicationContext(),list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(kontakAdapter);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                sharePrefManager.saveIsLogin(false);
                finishAffinity();
                startActivity(i);
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TambahKontak.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        list.clear();
        list.addAll(database.kontakDao().getAll());
        kontakAdapter.notifyDataSetChanged();
    }
}
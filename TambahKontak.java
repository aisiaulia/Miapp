package com.example.miapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.miapp.database.AppDatabase;
import com.example.miapp.database.entitas.Kontak;

public class TambahKontak extends AppCompatActivity {

    EditText etNama, etNo;
    Button btnSimpan;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kontak);

        etNama = findViewById(R.id.etNama);
        etNo = findViewById(R.id.etNo);
        btnSimpan = findViewById(R.id.btnSimpan);
        database = AppDatabase.getInstance(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Kontak kontak = new Kontak();
                kontak.fullName = etNama.getText().toString();
                kontak.no = etNo.getText().toString();
                database.kontakDao().insertAll(kontak);
                finish();
            }
        });
    }
}
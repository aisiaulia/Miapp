package com.example.miapp.database.entitas;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Kontak {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String no;

    @ColumnInfo(name = "full_name")
    public String fullName;
}

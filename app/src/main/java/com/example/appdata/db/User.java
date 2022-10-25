package com.example.appdata.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "npm")
    public String Npm;
    @ColumnInfo(name = "nama")
    public String Nama;
    @ColumnInfo(name = "kelas")
    public String Kelas;
    @ColumnInfo(name = "prodi")
    public String Prodi;

}

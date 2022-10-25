package com.example.appdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.appdata.db.AppDb;
import com.example.appdata.db.User;


public class Room extends AppCompatActivity {
 private    Button simpan, tampil;
  private   EditText editTextNm,editTextNpm,editTextPd,editTextKls;
  private TextView textView2,textView3,textView4,textView5,textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        final EditText editTextNpm =  findViewById(R.id.editTextNpm);
        final EditText editTextNm =  findViewById(R.id.editTextNm);
        final EditText editTextKls =  findViewById(R.id.editTextKls);
        final EditText editTextPd =  findViewById(R.id.editTextPd);


        Button button =  findViewById(R.id.simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(editTextNpm.getText().toString(), editTextNm.getText().toString(),
                        editTextKls.getText().toString(),editTextPd.getText().toString());

            }
        });
        Button button1 = findViewById(R.id.tampil);
        tampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OpenAct = new Intent(getApplicationContext(), List_room.class);
                startActivity(OpenAct);
            }
        });
    }

    private void saveNewUser(String Npm, String Nama,String Kelas, String Prodi) {
        AppDb db  = AppDb.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.Npm = Npm;
        user.Nama = Nama;
        user.Kelas = Kelas;
        user.Prodi = Prodi;
        db.userDao().insertUser(user);

        finish();

    }
}
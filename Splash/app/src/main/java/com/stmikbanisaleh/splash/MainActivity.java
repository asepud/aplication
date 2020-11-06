package com.stmikbanisaleh.splash;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.cardview.widget.CardView;

public class MainActivity extends Activity {
    CardView kontak;
    CardView keuangan;
    CardView kalender;
    CardView agenda;
    CardView note;
    CardView setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kontak = findViewById(R.id.kontak);
        keuangan = findViewById(R.id.keuangan);
        kalender = findViewById(R.id.kalender);
        agenda = findViewById(R.id.agenda);
        note = findViewById(R.id.note);
        setting = findViewById(R.id.setting);

        kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, kontak.class));

            }
        });
        keuangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, keuangan.class));

            }
        });
        kalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

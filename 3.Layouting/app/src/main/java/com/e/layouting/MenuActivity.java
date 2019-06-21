package com.e.layouting;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    //1.Kenalan - Buat Variabel
    Button btnLinear, btnRelative, btnFrame, btnConstraint, btnScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //2.Sambungin - inisialisasi variabel sesuai dengan idnya
        btnLinear = findViewById(R.id.btn_linear);
        btnRelative = findViewById(R.id.btn_relative);
        btnFrame = findViewById(R.id.btn_frame);
        btnConstraint = findViewById(R.id.btn_constraint);
        btnScroll = findViewById(R.id.btn_scroll);

        //3.Ngapain - event handling
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MenuActivity.this, "Ini Toast", Toast.LENGTH_SHORT).show();
                Intent pindah = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(pindah);
            }
        });

        btnRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Komponen variabel = new Komponen()
                //Context -> NamaActivity
                AlertDialog.Builder pesan = new AlertDialog.Builder(MenuActivity.this);
                pesan.setTitle("Alert Dialog");
                pesan.setMessage("Ini Alert Dialog");
                pesan.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActivity.this, "Anda memilih OK", Toast.LENGTH_SHORT).show();
                        Intent pindah = new Intent(MenuActivity.this, RelativeActivity.class);
                        startActivity(pindah);

                    }
                });
                pesan.setNegativeButton("NO", null);
                pesan.show();
            }
        });

        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MenuActivity.this, FrameActivity.class);
                startActivity(pindah);
            }
        });

        btnConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MenuActivity.this, ConstraintActivity.class);
                startActivity(pindah);
            }
        });

        btnScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(MenuActivity.this, ScrollActivity.class);
                startActivity(pindah);
            }
        });
    }
}

package com.e.a5listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    //logt
    private static final String TAG = "DetailActivity";

    TextView tvnamaBuah;
    ImageView ivgambarBuah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String namabuah = getIntent().getStringExtra(Konstanta.DATANAMA);
        int gambarbuah = getIntent().getIntExtra(Konstanta.DATAGAMBAR, 0);

        //log
        Log.d(TAG,"Nama: "+ namabuah);
        Log.d(TAG, "Gambar"+ gambarbuah);

        tvnamaBuah = findViewById(R.id.tv_detail_nama);
        ivgambarBuah = findViewById(R.id.iv_detail_gambar);

        tvnamaBuah.setText(namabuah);
        ivgambarBuah.setImageResource(gambarbuah);





    }
}

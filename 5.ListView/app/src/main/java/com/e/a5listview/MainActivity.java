package com.e.a5listview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] namaBuah = {
            "Alpukat",
            "Apel",
            "Ceri",
            "Durian"
    };

    int[] gambarBuah = {
            //ctrl+D = duplikat baris
            R.drawable.alpukat,
            R.drawable.apel,
            R.drawable.ceri,
            R.drawable.durian,
    };

    int[] suaraBuah = {
            //ctrl+r = replace
            R.raw.alpukat,
            R.raw.apel,
            R.raw.ceri,
            R.raw.durian,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list_view);
        //ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, namaBuah);
        CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, namaBuah, gambarBuah);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer.create(MainActivity.this, suaraBuah[position]).start();

                Intent pindah = new Intent(MainActivity.this, DetailActivity.class);
                pindah.putExtra(Konstanta.DATANAMA, namaBuah[position]);
                pindah.putExtra(Konstanta.DATAGAMBAR, gambarBuah[position]);
                startActivity(pindah);
        }



    });
    }

}
package com.e.a5listview;

import android.animation.LayoutTransition;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {
    private Context context;
    private String[] namabuah;
    private int[] gambarbuah;

    //klik kanan +generate + constructor

    public CustomListAdapter(Context context1, String[] namabuah, int[] gambarbuah) {
        super(context1, R.layout.item_buah, namabuah);
        this.context = context1;
        this.namabuah = namabuah;
        this.gambarbuah = gambarbuah;
    }

    //getView

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        //atur layout item
        LayoutInflater layoutInflater;
        View view = LayoutInflater.from(context).inflate(R.layout.item_buah, parent, false);

        //findViewById setiap komponen yang didalam item
        TextView tvNamaBuah = view.findViewById(R.id.tv_item_nama);
        ImageView ivGambarbuah = view.findViewById(R.id.iv_item_gambar);

        //set data
        tvNamaBuah.setText(namabuah[position]);
        ivGambarbuah.setImageResource(gambarbuah[position]);

        return view;
    }
}

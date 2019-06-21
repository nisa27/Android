package com.e.a4userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edSisi;
    Button btnHitung;
    TextView tvHasil;
    Spinner spinnerPilihan;
    String[] pilihanHitung = {"Volume", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSisi = findViewById(R.id.ed_sisi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        spinnerPilihan = findViewById(R.id.spinner_pilihan);


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[0])){
                    //rumus volume
                    rumusVolume();
                    //ctrl+alt+M
                }else if(spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[1])){
                    //rumus keliling
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    rumusKeliling(sisi);
                }else if(spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[2])){
                    //rumus luas permukaan
                    Double hasil = rumusLuasPermukaan();
                    tvHasil.setText(hasil.toString());
                }

            }
        });

        //data
        //adapters
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_dropdown_item_1line, pilihanHitung);
        spinnerPilihan.setAdapter(adapter);
    }

    private Double rumusLuasPermukaan() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = 12 * sisi;
        return hasil;
    }

    private void rumusKeliling(Double sisi) {
        Double hasil = 6 * sisi + sisi;
        tvHasil.setText(hasil.toString());
    }

    private void rumusVolume() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = sisi * sisi *sisi;
        tvHasil.setText(hasil.toString());
    }
}

package com.nisa.uas_ku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edNama, edNohp, edAlamat;
    Spinner spJk;
    Button btnSave, btnTampil;
    String[] pilihan = {"Laki-Laki", "Perempuan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNama = findViewById(R.id.ed_nama);
        edNohp = findViewById(R.id.ed_nohp);
        edAlamat = findViewById(R.id.ed_alamat);
        spJk = findViewById(R.id.sp_spinner);
        btnSave = findViewById(R.id.save);
        btnTampil = findViewById(R.id.tampil);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihan);
        spJk.setAdapter(adapter);

        btnSave.setOnClickListener(this);
        btnTampil.setOnClickListener(this);
    }


    private void addEmployee(){

        final String nama = edNama.getText().toString().trim();
        final String nohp = edNohp.getText().toString().trim();
        final String alamat = edAlamat.getText().toString().trim();
        final String jk = spJk.getSelectedItem().toString();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_NAMA,nama);
                params.put(Konfigurasi.KEY_NOHP,nohp);
                params.put(Konfigurasi.KEY_ALAMAT,alamat);
                params.put(Konfigurasi.KEY_JK,jk);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Konfigurasi.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == btnSave){
            addEmployee();
        }

        if(v == btnTampil){
            startActivity(new Intent(this,TampilActivity.class));
        }
    }
}

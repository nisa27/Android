package com.nisa.myuas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FormHajiActivity extends AppCompatActivity implements View.OnClickListener{
    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText editTextNama;
    private EditText editTextAlamat;
    private EditText editTextKontak;
    ProgressDialog progressDialog;
    Spinner spJk;
    private Button buttonAdd;
    private Button buttonView;

    Spinner spinnerJK;
    String[] pilihan = {"Laki-Laki", "Perempuan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_haji);
        //Inisialisasi dari View

        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);
        editTextKontak = (EditText) findViewById(R.id.editTextKontak);
        spJk = findViewById(R.id.sp_spinner);

        ArrayAdapter adapter = new ArrayAdapter(FormHajiActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihan);
        spJk.setAdapter(adapter);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);

    }

    //Dibawah ini merupakan perintah untuk Menambahkan Minimarket (CREATE)
    private void addHaji(){

        final String nama = editTextNama.getText().toString().trim();
        final String alamat= editTextAlamat.getText().toString().trim();
        final String nohp = editTextKontak.getText().toString().trim();
        final String jenis_kelamin = spJk.getSelectedItem().toString();


        class AddHaji extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(FormHajiActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(FormHajiActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();

                params.put(ApiClient.KEY_MM_NAMA,nama);
                params.put(ApiClient.KEY_MM_ALAMAT,alamat);
                params.put(ApiClient.KEY_MM_NOHP,nohp);
                params.put(ApiClient.KEY_MM_JENIS_KELAMIN,jenis_kelamin);
                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(ApiClient.URL_ADD, params);
                return res;
            }
        }

        AddHaji ae = new AddHaji();
        ae.execute();
    }

    //@Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addHaji();
        }

        if(v == buttonView){
            startActivity(new Intent(this,ShowAll.class));
        }
    }
}

package com.nisa.myuas;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;



public class ShowAll extends AppCompatActivity implements ListView.OnItemClickListener{

    private ListView listView;

    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_all);
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getJSON();
    }


    private void showHaji(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(ApiClient.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(ApiClient.TAG_ID);
                String nama = jo.getString(ApiClient.TAG_NAMA);
                String nohp = jo.getString(ApiClient.TAG_NOHP);
                String alamat = jo.getString(ApiClient.TAG_ALAMAT);
                String jenis_kelamin = jo.getString(ApiClient.TAG_JENIS_KELAMIN);

                HashMap<String,String> haji = new HashMap<>();
                haji.put(ApiClient.TAG_ID,id);
                haji.put(ApiClient.TAG_NAMA,nama);
                haji.put(ApiClient.TAG_NOHP,nohp);
                haji.put(ApiClient.TAG_ALAMAT,alamat);
                haji.put(ApiClient.TAG_JENIS_KELAMIN,jenis_kelamin);
                list.add(haji);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                ShowAll.this, list, R.layout.list_item,
                new String[]{ApiClient.TAG_NAMA,ApiClient.TAG_ALAMAT, ApiClient.TAG_JENIS_KELAMIN},
                new int[]{R.id.nama, R.id.editTextKontak, R.id.editTextAlamat, R.id.jenis_kelamin});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ShowAll.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showHaji();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(ApiClient.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Show.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String mm_id = map.get(ApiClient.TAG_ID).toString();
        intent.putExtra(ApiClient.MM_ID,mm_id);
        startActivity(intent);
    }
}

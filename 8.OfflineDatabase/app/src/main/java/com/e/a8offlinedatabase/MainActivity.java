package com.e.a8offlinedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.arlib.floatingsearchview.FloatingSearchView;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<CatatanModul> dataCatatn = new ArrayList<>();
    RecyclerView recycler;
    RealmHelper realm;
    FloatingSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahCatatanActivity.class));
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });


        realm = new RealmHelper(MainActivity.this);
        //1.membuat layout per item
        //2.membuat data model
//        CatatanModul catatan1 = new CatatanModul();
//        catatan1.setId(1);
//        catatan1.setJudul("Hutang ke A");
//        catatan1.setJumlahhutang("20000");
//        catatan1.setTangggal("12-12-2012");
//
//        for (int i = 0; i <20; i++){
//            dataCatatn.add(catatan1);
//        }

        //get data realm
        dataCatatn = realm.showData();
        //3.adapter
        recycler = findViewById(R.id.recyclerView);
        recycler.setAdapter(new CatatanAdapter(MainActivity.this, dataCatatn));

        //4.layout manager
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(MainActivity.this, 1));

        searchView = findViewById(R.id.floating_search_view);

        searchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {
                Toast.makeText(MainActivity.this, ""+newQuery,Toast.LENGTH_SHORT).show();
                //Filter searchView
                List<CatatanModul> filterCatatan = filterData(dataCatatn, newQuery);
                recycler.setAdapter(new CatatanAdapter(MainActivity.this, filterCatatan));
            }
        });
    }

    private List<CatatanModul> filterData(List<CatatanModul> dataCatatn, String newQuery) {
        String lowercasequery = newQuery.toLowerCase();
        List<CatatanModul> filterData = new ArrayList<>();
        for (int i = 0; i <  dataCatatn.size(); i++ ){
            String text = dataCatatn.get(i).getJudul().toLowerCase();
            if (text.contains(lowercasequery)) {
                filterData.add(dataCatatn.get(i));
            }
        }
        return filterData;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataCatatn = realm.showData();
        recycler.setAdapter(new CatatanAdapter(MainActivity.this, dataCatatn));

    }
}

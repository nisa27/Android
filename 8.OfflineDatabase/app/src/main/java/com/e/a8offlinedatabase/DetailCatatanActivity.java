package com.e.a8offlinedatabase;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DetailCatatanActivity extends AppCompatActivity {

    EditText edJudul, edJumlah, edTanggal;
    Button btnUpdate, btnDelete;

    public static final String KEY_ID = "key_id";
    RealmHelper realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catatan);

        realm = new RealmHelper(DetailCatatanActivity.this);

        final int dataID = getIntent().getIntExtra(KEY_ID, 0);

        edJudul = findViewById(R.id.ed_judul);
        edJumlah = findViewById(R.id.ed_jumlah);
        edTanggal = findViewById(R.id.ed_tanggal);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);

        CatatanModul data = realm.showOneData(dataID);

        edJudul.setText(data.getJudul());
        edJumlah.setText(data.getJumlahhutang());
        edTanggal.setText(data.getTangggal());

        edTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //date picker
                Calendar calendar = Calendar.getInstance();
                //Date nowDate = calendar.getTime();
                int nowYear = calendar.get(Calendar.YEAR);
                int nowMonth = calendar.get(Calendar.MONTH);
                int nowDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(DetailCatatanActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, month, dayOfMonth);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                        edTanggal.setText(dateFormat.format(cal.getTime()));
                    }
                }, nowYear, nowMonth, nowDay);
                dialog.show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatatanModul catatan = new CatatanModul();
                catatan.setId(dataID);
                catatan.setJudul(edJudul.getText().toString());
                catatan.setJumlahhutang(edJumlah.getText().toString());
                catatan.setTangggal(edTanggal.getText().toString());

                realm.updateData(catatan);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.deleteData(dataID);
                finish();
            }
        });
    }
}

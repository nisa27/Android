package com.nisa.uas_ku;

public class Konfigurasi {
    public static final String URL_ADD="http://192.168.43.127/haji/add.php";
    public static final String URL_GET_ALL="http://192.168.43.127/haji/show_all.php";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_NOHP = "nohp"; //desg itu variabel untuk posisi
    public static final String KEY_ALAMAT = "alamat"; //salary itu variabel untuk gajih
    public static final String KEY_JK = "jk"; //salary itu variabel untuk gajih

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_NOHP = "nohp";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_JK = "jk";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}

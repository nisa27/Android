package com.nisa.myuas;




public class ApiClient {

   //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.43.127/haji/add.php";
    public static final String URL_GET_ALL = "http://192.168.127/haji/show_all.php";
    public static final String URL_GET_EMP = "http://192.168.43.127/haji/show.php?id=";
//    public static final String URL_UPDATE_EMP = "http://192.168.43.33/kuis_uts/update.php";
//    public static final String URL_DELETE_EMP = "http://192.168.43.33/kuis_uts/delete.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_MM_ID = "id";
    public static final String KEY_MM_NAMA = "nama";
    public static final String KEY_MM_ALAMAT = "alamat";
    public static final String KEY_MM_NOHP = "nohp";
    public static final String KEY_MM_JENIS_KELAMIN = "jenis_kelamin";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_ALAMAT= "alamat";
    public static final String TAG_NOHP = "nohp";
    public static final String TAG_JENIS_KELAMIN = "jenis_kelamin";
    //ID MM(MiniMarket)
    public static final String MM_ID = "mm_id";
}

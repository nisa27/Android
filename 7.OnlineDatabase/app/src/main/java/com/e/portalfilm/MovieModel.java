package com.e.portalfilm;

import com.google.gson.annotations.SerializedName;

public class MovieModel {

    @SerializedName("title")
    private  String judulFilm;

    @SerializedName("poster_path")
    private String posterFile;

    public String getJudulFilm() {
        return judulFilm;
    }

    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public String getPosterFile() {
        return posterFile;
    }

    public void setPosterFile(String posterFile) {
        this.posterFile = posterFile;
    }



    //setter and getter
    //klik kanan > generate > getter and setter


}

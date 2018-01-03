package com.example.brianr.himasifmobile;

import java.util.ArrayList;

/**
 * Created by Brian R on 28/12/2017.
 */

public class model {
    private int id;
    private String nama, nim;
    private ArrayList<String> mahasiswa;

    public model(int id, String nama, String nim, ArrayList<String> mahasiswa) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.mahasiswa = mahasiswa;
    }
    public model(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public ArrayList<String> getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(ArrayList<String> mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}

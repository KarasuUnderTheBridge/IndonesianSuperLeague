package com.twokangid.indonesiansuperleague.database;

public class ModelDataKlub {
    int id;
    String nama, kota;
    int jumlahMain, poin, jumlahMenang, jumlahKalah, jumlahSeri, jumlahGoal, jumlahKebobolan;

    public ModelDataKlub(String nama, String kota, int jumlahMain, int poin, int jumlahMenang, int jumlahKalah, int jumlahSeri, int jumlahGoal, int jumlahKebobolan) {

        this.nama = nama;
        this.kota = kota;
        this.jumlahMain = jumlahMain;
        this.poin = poin;
        this.jumlahMenang = jumlahMenang;
        this.jumlahKalah = jumlahKalah;
        this.jumlahSeri = jumlahSeri;
        this.jumlahGoal = jumlahGoal;
        this.jumlahKebobolan = jumlahKebobolan;
    }

    public ModelDataKlub(String nama, String kota) {
        this.nama = nama;
        this.kota = kota;
    }

    public ModelDataKlub(String nama) {
        this.nama = nama;
    }

    public ModelDataKlub() {
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

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public int getJumlahMain() {
        return jumlahMain;
    }

    public void setJumlahMain(int jumlahMain) {
        this.jumlahMain = jumlahMain;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public int getJumlahMenang() {
        return jumlahMenang;
    }

    public void setJumlahMenang(int jumlahMenang) {
        this.jumlahMenang = jumlahMenang;
    }

    public int getJumlahKalah() {
        return jumlahKalah;
    }

    public void setJumlahKalah(int jumlahKalah) {
        this.jumlahKalah = jumlahKalah;
    }

    public int getJumlahSeri() {
        return jumlahSeri;
    }

    public void setJumlahSeri(int jumlahSeri) {
        this.jumlahSeri = jumlahSeri;
    }

    public int getJumlahGoal() {
        return jumlahGoal;
    }

    public void setJumlahGoal(int jumlahGoal) {
        this.jumlahGoal = jumlahGoal;
    }

    public int getJumlahKebobolan() {
        return jumlahKebobolan;
    }

    public void setJumlahKebobolan(int jumlahKebobolan) {
        this.jumlahKebobolan = jumlahKebobolan;
    }
}

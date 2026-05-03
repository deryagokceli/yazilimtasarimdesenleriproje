package com.akinciteknik.servis.config;

public class DatabaseManager {

    private static DatabaseManager instance;

    private DatabaseManager() {
        System.out.println("DatabaseManager olusturuldu");
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void baglantiKontrol() {
        System.out.println("Veritabani baglantisi kontrol edildi");
    }
}
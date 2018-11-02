package com.awesome.mariadmar.realtimedatabase;

public class Nombres {

    String nombresId;
    String nombresName;
    String nombreGenre;

    public Nombres(){

    }

    public Nombres(String nombresId, String nombresName, String nombreGenre) {
        this.nombresId = nombresId;
        this.nombresName = nombresName;
        this.nombreGenre = nombreGenre;
    }

    public String getNombresId() {
        return nombresId;
    }

    public String getNombresName() {
        return nombresName;
    }

    public String getNombreGenre() {
        return nombreGenre;
    }
}

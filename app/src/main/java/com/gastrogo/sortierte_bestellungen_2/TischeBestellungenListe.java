package com.gastrogo.sortierte_bestellungen_2;

import java.util.ArrayList;

public class TischeBestellungenListe {
    private static TischeBestellungenListe instance;
    private TischeBestellungenListe() {
    }

    public static ArrayList<TischeBestellungenModel> tischBestellungenListe = new ArrayList<>();

    public static TischeBestellungenListe getInstance() {
        if (instance == null) {
            instance = new TischeBestellungenListe();
        }
        return instance;
    }

}

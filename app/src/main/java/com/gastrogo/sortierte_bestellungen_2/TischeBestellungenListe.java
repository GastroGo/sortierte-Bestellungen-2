package com.gastrogo.sortierte_bestellungen_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TischeBestellungenListe {
    private static TischeBestellungenListe instance;
    private static int clickedTable;
    private TischeBestellungenListe() {
    }

    public static ArrayList<TischeBestellungenModel> tischBestellungenListe = new ArrayList<>();

    public static TischeBestellungenListe getInstance() {
        if (instance == null) {
            instance = new TischeBestellungenListe();
        }
        return instance;
    }

    public static int getClickedTable() {
        return clickedTable;
    }

    public static void setClickedTable(int klickedTable) {
        TischeBestellungenListe.clickedTable = klickedTable;
    }

    public static void sortTischBestellungenListe() {
        // Sort the list based on the 'isBestellungAktiv' flag and 'timer'
        Collections.sort(TischeBestellungenListe.tischBestellungenListe, new Comparator<TischeBestellungenModel>() {
            @Override
            public int compare(TischeBestellungenModel t1, TischeBestellungenModel t2) {
                // Sort by 'isBestellungAktiv' flag in descending order (true comes first)
                int flagComparison = Boolean.compare(t2.getBestellungAktiv(), t1.getBestellungAktiv());

                // If 'isBestellungAktiv' flags are equal
                if (flagComparison == 0) {
                    // If 'BestellungAktiv' is false, sort by table number
                    if (!t1.getBestellungAktiv()) {
                        return Integer.compare(t1.getTischNr(), t2.getTischNr());
                    }

                    // If 'BestellungAktiv' is true, sort by 'timer' in ascending order
                    return Integer.compare(t1.getTimer(), t2.getTimer());
                }

                return flagComparison;
            }
        });
    }


}

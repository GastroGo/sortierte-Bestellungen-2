package com.gastrogo.sortierte_bestellungen_2;

public class TischeBestellungenModel {
    private int tischNr;
    private int timer;
    private boolean isBestellungAktiv;

    public TischeBestellungenModel(int tischNr, int timer, boolean isBestellungAktiv) {
        this.tischNr = tischNr;
        this.timer = timer;
        this.isBestellungAktiv = isBestellungAktiv;
    }

    public int getTischNr() {
        return tischNr;
    }

    public int getTimer() {
        return timer;
    }

    public boolean getBestellungAktiv() {
        return isBestellungAktiv;
    }


}

package com.gastrogo.sortierte_bestellungen_2.DBKlassen;

public class TablelistModel {

    private static TablelistModel instance;

    private Tische tischeArray[];



    private int numberOfTables;

    private TablelistModel() {
    }

    public static TablelistModel getInstance() {
        if (instance == null) {
            instance = new TablelistModel();
        }
        return instance;
    }

    public Tische[] getTischeArray(){
        return tischeArray;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public void setup(){
        tischeArray = new Tische[numberOfTables];
    }

    public void setup(int numberOfTables){
        this.numberOfTables = numberOfTables;
        tischeArray = new Tische[this.numberOfTables];
    }

}

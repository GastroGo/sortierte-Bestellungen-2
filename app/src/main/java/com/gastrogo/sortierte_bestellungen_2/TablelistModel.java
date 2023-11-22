package com.gastrogo.sortierte_bestellungen_2;

import java.util.ArrayList;

public class TablelistModel {

    private static TablelistModel instance;

    private ArrayList<TableData> tableDataArrayList;

    private TablelistModel() {
        tableDataArrayList = new ArrayList<>();
    }

    public static TablelistModel getInstance() {
        if (instance == null) {
            instance = new TablelistModel();
        }
        return instance;
    }

    public static ArrayList<TableData> getTableDataArrayList() {
        return instance.tableDataArrayList;
    }

    public void fillDateSet(int numberOfTables){
        for(int x = 1; x < numberOfTables + 1; x++){
            instance.tableDataArrayList.add(new TableData(x, "0", true));
        }
    }

    public int getTableNr(int index){
        return tableDataArrayList.get(index).getTableNumber();
    }

    public String getTableTimer(int index){
        return tableDataArrayList.get(index).getTableTimer();
    }

    public boolean getTableStatus(int index){
        return tableDataArrayList.get(index).getTableStatus();
    }

    public void setTableSatus(int index, boolean status){
        tableDataArrayList.get(index).setTableStatus(status);
    }

}

package com.gastrogo.sortierte_bestellungen_2;

public class TableData {

    private int tableNumber;
    private String tableTimer;
    private boolean tableStatus;

    public TableData(int tableNumber, String tableTimer, boolean tableStatus) {
        this.tableNumber = tableNumber;
        this.tableTimer = tableTimer;
        this.tableStatus = tableStatus;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getTableTimer() {
        return tableTimer;
    }

    public void setTableTimer(String tableTimer) {
        this.tableTimer = tableTimer;
    }

    public boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public void changeTableStatus() {
        this.tableStatus = !this.tableStatus;
    }
}

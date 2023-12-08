package com.gastrogo.sortierte_bestellungen_2.Tisch;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gastrogo.sortierte_bestellungen_2.DBKlassen.GerichteModel;
import com.gastrogo.sortierte_bestellungen_2.DBKlassen.TablelistModel;
import com.gastrogo.sortierte_bestellungen_2.R;

import java.util.ArrayList;
import java.util.Map;

public class RV_Adapter_Bestellungen extends RecyclerView.Adapter<RV_Adapter_Bestellungen.ViewHolder> {

    int tableNumber;
    TablelistModel tableListO = TablelistModel.getInstance();
    GerichteModel gerichteListeO = GerichteModel.getInstance();
    ArrayList<String[]> tableOrders = new ArrayList<String[]>();

    public RV_Adapter_Bestellungen(int tableNumber){
        this.tableNumber = tableNumber;
    }

    @NonNull
    @Override
    public RV_Adapter_Bestellungen.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_row_bestellung, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RV_Adapter_Bestellungen.ViewHolder holder, int position) {
        holder.dishName.setText(tableOrders.get(position)[0]);
        holder.dishName.setText(gerichteListeO.getGerichtName(tableOrders.get(position)[0]));
        holder.numberDishes.setText(tableOrders.get(position)[1]);
    }

    @Override
    public int getItemCount() {
        int counter = 0;

        for (Map.Entry<String, Integer> entry : tableListO.getTischeArray()[tableNumber-1].getBestellungen().entrySet()) {
            //restaurantTische.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            if(entry.getValue() != 0){
                tableOrders.add(new String[]{entry.getKey(), String.valueOf(entry.getValue())});
                counter ++;
            }
        }

        return counter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView dishName;
        private TextView numberDishes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.dishName = itemView.findViewById(R.id.RV_TV_DishName);
            this.numberDishes = itemView.findViewById(R.id.RV_TV_NumberDishes);
        }

        public TextView getDishName() {
            return dishName;
        }

        public TextView getNumberDishes() {
            return numberDishes;
        }

    }
}

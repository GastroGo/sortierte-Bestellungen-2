package com.gastrogo.sortierte_bestellungen_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gastrogo.sortierte_bestellungen_2.Data.TablelistModel;

public class MainActivity extends AppCompatActivity {

    TablelistModel tableListO = TablelistModel.getInstance();
    Button randStatusBT;
    RecyclerView recyclerView;
    int NumberOfTables = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randStatusBT = findViewById(R.id.RandButton);



        tableListO.fillDateSet(NumberOfTables);

        recyclerView = findViewById(R.id.mRecyclerView);
        RV_Adapter_Tische adapterTische = new RV_Adapter_Tische();
        recyclerView.setAdapter(adapterTische);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        randStatusBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = (int) (Math.random() * (NumberOfTables - 1) + 1);
                tableListO.setTableSatus(index , !tableListO.getTableStatus(index));
                tableListO.sortTischBestellungenListe();
                adapterTische.notifyDataSetChanged();
            }
        });
    }
}

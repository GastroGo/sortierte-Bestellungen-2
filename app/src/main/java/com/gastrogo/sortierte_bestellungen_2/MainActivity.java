package com.gastrogo.sortierte_bestellungen_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gastrogo.sortierte_bestellungen_2.DBKlassen.Daten;
import com.gastrogo.sortierte_bestellungen_2.DBKlassen.Tische;
import com.gastrogo.sortierte_bestellungen_2.Data.TablelistModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = database.getReference("Restaurants");

    TablelistModel tableListO = TablelistModel.getInstance();
    Button randStatusBT;
    RecyclerView recyclerView;
    Tische tische;
    int NumberOfTables = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tische = Tische.getInstance();
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

        dbRef.child("-NkF_dqyroONEdMqgfgC").addValueEventListener(new ValueEventListener(){


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tische.setInstance(snapshot.child("tische").getValue(Tische.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}




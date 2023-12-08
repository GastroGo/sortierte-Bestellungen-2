package com.gastrogo.sortierte_bestellungen_2.Bestellungen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.gastrogo.sortierte_bestellungen_2.DBKlassen.TablelistModel;
import com.gastrogo.sortierte_bestellungen_2.DBKlassen.Tische;
import com.gastrogo.sortierte_bestellungen_2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BestellungenActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = database.getReference("Restaurants");
    TablelistModel tableListO = TablelistModel.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tisch_bestellungen);

        TextView title = findViewById(R.id.TischBestellungenTitle);

        int tischNr = getIntent().getIntExtra("TableNr", -1);

        RecyclerView recyclerView = findViewById(R.id.BestellungenRecyclerView);
        RV_Adapter_Bestellungen adapterBestellungen = new RV_Adapter_Bestellungen(tischNr);
        recyclerView.setAdapter(adapterBestellungen);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        title.setText("Tisch " + tischNr);

        Button back = findViewById(R.id.TischBestellungenBack);
        back.setOnClickListener(view -> finish());

        dbRef.child("-NkF_dqyroONEdMqgfgC").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int NumberOfTables = (int) snapshot.child("tische").getChildrenCount();
                tableListO.setup(NumberOfTables);

                for(int x = 0; x < NumberOfTables; x++){
                    String xString = String.format("%03d", (x + 1));
                    tableListO.getTischeArray()[x] = snapshot.child("tische").child(xString).getValue(Tische.class);
                }

                adapterBestellungen.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });
    }

}
package com.gastrogo.sortierte_bestellungen_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    TablelistModel tableListO = TablelistModel.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableListO.fillDateSet(20);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        RV_Adapter_Tische adapterTische = new RV_Adapter_Tische();
        recyclerView.setAdapter(adapterTische);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }
}

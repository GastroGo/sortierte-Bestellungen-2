package com.gastrogo.sortierte_bestellungen_2;

import static com.gastrogo.sortierte_bestellungen_2.TB_RecyclerViewAdapter.context;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TischBestellungen extends AppCompatActivity {

    TischeBestellungenListe tischeBestellungenListe = TischeBestellungenListe.getInstance();
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tisch_bestellungen);

        Button goBackButton = findViewById(R.id.GoBackButton);
        title = findViewById(R.id.tvTitle);
        title.setText("Bestellungen - Tisch " + tischeBestellungenListe.getClickedTable());

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToTables();
            }
        });
    }

    private void goBackToTables() {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
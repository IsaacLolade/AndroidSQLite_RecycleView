package com.example.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_player;

    Nominated retrieveplayer;
    ArrayList<String> player_id, player_name, player_number, player_club,player_position;

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recicleView);
        add_player = findViewById(R.id.floatingButton);  // asociar al boton flotante de +
        add_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main.this, AddPlayer.class);
                startActivity(intent);// Para desplazaranos hacía la siuguente pantalla desde la pagina principal
            }
        });

        retrieveplayer= new Nominated(Main.this);
        // ArrayList  de las columnas que se encuentran en la base de datos
        player_id = new ArrayList<>();
        player_name = new ArrayList<>();
        player_club = new ArrayList<>();
        player_position = new ArrayList<>();
        player_number = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(Main.this, player_id,player_name,player_club,player_number,player_position);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Main.this));
    }

    void storeDataInArrays(){
        Cursor cursor = retrieveplayer.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No se ha podido encontrar ningun dato", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                player_id.add(cursor.getString(0));
                player_name.add(cursor.getString(1));
                player_club.add(cursor.getString(2));
                player_position.add(cursor.getString(3));
                player_number.add(cursor.getString(4));
            }
        }
    }

}

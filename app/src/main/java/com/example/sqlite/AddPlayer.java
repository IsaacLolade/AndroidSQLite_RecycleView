package com.example.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class AddPlayer extends AppCompatActivity {
    TextView name, club, number,position;
    Button add_player;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.nominados);

        name = findViewById(R.id.PlayerName);
        club = findViewById(R.id.Club);
        number = findViewById(R.id.number);
        position = findViewById(R.id.position);
        add_player = findViewById(R.id.addPLayer);
        add_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nominated sqlite = new Nominated(AddPlayer.this); // creamos el objeto el cual utilizaremos de base de datos
                sqlite.addPlayer(name.getText().toString(),club.getText().toString(),Integer.valueOf(number.getText().toString()),position.getText().toString()); // cogemos todos los campos introducidos y los añadimos al metodo addplayer que sirve para introducir nuevos datos
            }
        });
    }
}

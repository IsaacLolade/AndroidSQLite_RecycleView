package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Nominated extends SQLiteOpenHelper {


    private Context context;
    private static final String DATABASE_NAME = "GoldBall.db"; // Asiganm,os nombre de la base de datos
    private static final int DATABASE_VERSION = 1; // asignaremos la version correspondiente a la base de datos
    private static final String TABLE_NAME = "Nominated_Players";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PLAYERNAME="Jugador";
    private static final String COLUMN_PLAYERCLUB="Equipo";
    private static final String COLUMN_PLAYERPOSITION="Posición";
    private static final String COLUMN_PLAYERNUMBER="Número_camiseta";
    public Nominated(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       String query = "CREATE TABLE "+ TABLE_NAME+
               "( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
               COLUMN_PLAYERNAME+ " TEXT, " +
               COLUMN_PLAYERCLUB+ " TEXT, " +
               COLUMN_PLAYERPOSITION+ " TEXT, " +
               COLUMN_PLAYERNUMBER+ " INTEGER); ";
       db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    void addPlayer(String playerName, String playerClub, int playerNumber, String position){
        SQLiteDatabase db = this.getWritableDatabase(); // get our database to  be able to write
        ContentValues cv = new ContentValues(); // List of the values that will be asigne to each column

        cv.put(COLUMN_PLAYERNAME,playerName); // puts the name from the player at the playername Column
        cv.put(COLUMN_PLAYERCLUB,playerClub); // puts the player's club information at the playerClub Column
        cv.put(COLUMN_PLAYERNUMBER, playerNumber); // puts the player's number at the playerNumber Column
        cv.put(COLUMN_PLAYERPOSITION, position); // puts the player's position at the playerPosition Column
        long result = db.insert(TABLE_NAME,null,cv); // inserts the data retrieved into the database
        if (result  == -1){
            Toast.makeText(context, "No se ha podido añadir a la base de datos", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Se ha añadido satisfactoriamente a la base de datos",Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){

        String query =  " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase(); // get our database to  be able to read

        Cursor cursor = null;

        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}

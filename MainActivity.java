package com.example.films;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView film;
    String[] films;
    boolean[] checkFilms;
    Resources r;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = getResources();
        films = r.getStringArray(R.array.films);
        checkFilms = new boolean[films.length];
        for (int i = 0; i < films.length ; i++) {
            checkFilms[i] = false;
        }
        Log.d("check", Arrays.toString(checkFilms));
        int k = (int) (Math.random()*10);
        Log.d("number", Integer.toString(k));
        film = findViewById(R.id.filmText);
        film.setText(films[k]);
        checkFilms[k] = true;
        Log.d("check", Arrays.toString(checkFilms));
    }

    public void onClickNext (View view){
        film = findViewById(R.id.filmText);
        int k = (int) (Math.random()*10);
        while (checkFilms[k] != false) {
            k = (int) (Math.random()*10);
        }
        int countOfTrue = 0;
        for (int i = 0; i < films.length; i++) {
            if (checkFilms[i] == true){
                countOfTrue++;
            }
        }
        if (countOfTrue != films.length-1) {
            film.setText(films[k]);
            checkFilms[k] = true;
            Log.d("check", Arrays.toString(checkFilms));
        }
        else{
            buttonNext = findViewById(R.id.buttonNext);
            buttonNext.setVisibility(View.INVISIBLE);
            film.setText("Вы посмотрели все фильмы.");
        }
    }

    public void onClickReset (View view){
        buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setVisibility(View.VISIBLE);
        for (int i = 0; i < films.length ; i++) {
            checkFilms[i] = false;
        }
        Log.d("check", Arrays.toString(checkFilms));
        int k = (int) (Math.random()*10);
        while (checkFilms[k] != false) {
            k = (int) (Math.random()*10);
        }
        film.setText(films[k]);
        checkFilms[k] = true;
    }
}




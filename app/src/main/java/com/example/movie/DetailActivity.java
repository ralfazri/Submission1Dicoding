package com.example.movie;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String DATA_FILM = "DATA_FILM" ;

    String titleData, contentData;
    int imageData;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        final ImageView img= (ImageView) findViewById(R.id.imgFilm);
        final TextView content= (TextView) findViewById(R.id.contentFilm);
        final  TextView title = (TextView) findViewById(R.id.titleFilm);

        ArrayList<Film> films = this.getIntent().getParcelableArrayListExtra(DATA_FILM);

        titleData = films.get(0).getTitle();
        content.setText(titleData);

        contentData = films.get(0).getContent();
        title.setText(contentData);

        imageData = films.get(0).getImage();
        img.setImageResource(imageData);

    }
}

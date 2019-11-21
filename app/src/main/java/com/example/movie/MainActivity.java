package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] name, content;
    private TypedArray image;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);

        ListView listView = findViewById(R.id.lv_listFilm);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent moveWithObject = new Intent(MainActivity.this, DetailActivity.class);

                ArrayList<Film> films = new ArrayList<>();

                Film film = new Film();
                film.setTitle(name[position]);
                film.setContent(content[position]);
                film.setImage(image.getResourceId(position, -1));

                films.add(film);
                moveWithObject.putParcelableArrayListExtra(DetailActivity.DATA_FILM, films);
                startActivity(moveWithObject);

            }
        });

        prepare();

        addItem();

    }

    @Override
    public void onClick(View v){

    }

    private void prepare(){
        name = getResources().getStringArray(R.array.data_nameFilm);
        content = getResources().getStringArray(R.array.data_title);
        image = getResources().obtainTypedArray(R.array.data_photoFilm);
    }

    private  void addItem(){

        films = new ArrayList<>();

        for (int i = 0; i < name.length; i++){
            Film film = new Film();
            film.setTitle(name[i]);
            film.setContent(content[i]);
            film.setImage(image.getResourceId(i, -1));
            films.add(film);
        }

        adapter.setFilmList(films);
    }
}

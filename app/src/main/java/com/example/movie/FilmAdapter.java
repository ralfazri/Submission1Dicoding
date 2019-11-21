package com.example.movie;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Film> films =  new ArrayList<>();

    void setFilmList(ArrayList<Film> films){ this.films = films; }

    FilmAdapter(Context context) { this.context = context; }

    @Override
    public int getCount(){ return films.size(); }

    @Override
    public Object getItem(int i) { return films.get(i); }

    @Override
    public long getItemId(int i ){return i; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        View itemView = view;

        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup ,false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        Film film =(Film) getItem(i);
        viewHolder.bind(film);
        return  itemView;
    }



    private class  ViewHolder{
        private TextView nameFilm, contentFilm;
        private ImageView img;

        ViewHolder(View view){
            nameFilm = view.findViewById(R.id.txt_titleFilm);
            contentFilm = view.findViewById(R.id.txt_description);
            img = view.findViewById(R.id.img_posterFilm);
        }

        void bind(Film film){
            nameFilm.setText(film.getTitle());
            contentFilm.setText(film.getContent());
            img.setImageResource(film.getImage());
        }
    }
}

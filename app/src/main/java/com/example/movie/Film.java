package com.example.movie;


import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {

    private int image;
    private String title;
    private String content;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Film(){

    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel prcl, int flags){
        prcl.writeString(this.content);
        prcl.writeString(this.title);
        prcl.writeInt(this.image);
    }

    protected Film(Parcel fil){
        this.title = fil.readString();
        this.content = fil.readString();
        this.image = fil.readInt();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}

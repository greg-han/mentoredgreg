package com.mentoredgreg.kafkaproject.model;

import org.apache.solr.client.solrj.beans.Field;

public class Song {
    @Field
    private String name;
    @Field
    private String album;
    @Field
    private String lyrics;

    public Song(){
    }

    public Song(String name, String album, String lyrics){
        this.name = name;
        this.album = album;
        this.lyrics = lyrics;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAlbum(){
        return this.album;
    }

    public void setAlbum(String album){
        this.album = album;
    }

    public String getLyrics(){
        return this.lyrics;
    }

    public void setLyrics(String lyrics){
        this.lyrics = lyrics;
    }

    @Override
    public String toString(){
        return "Name:\n" + getName() + "\n" + "Lyrics:\n" +  getLyrics();
    }

}

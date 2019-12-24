package com.example.anime.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("description")
@Expose
private String description;
@SerializedName("songAddress")
@Expose
private String songAddress;
@SerializedName("thumbnail")
@Expose
private String thumbnail;
@SerializedName("songs")
@Expose
private Object songs;
@SerializedName("employee")
@Expose
private Object employee;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getSongAddress() {
return songAddress;
}

public void setSongAddress(String songAddress) {
this.songAddress = songAddress;
}

public String getThumbnail() {
return thumbnail;
}

public void setThumbnail(String thumbnail) {
this.thumbnail = thumbnail;
}

public Object getSongs() {
return songs;
}

public void setSongs(Object songs) {
this.songs = songs;
}

public Object getEmployee() {
return employee;
}

public void setEmployee(Object employee) {
this.employee = employee;
}

}
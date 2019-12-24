package com.example.anime.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Song {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("genre")
@Expose
private String genre;
@SerializedName("vocal")
@Expose
private String vocal;
@SerializedName("country")
@Expose
private String country;
@SerializedName("description")
@Expose
private String description;
@SerializedName("songAddress")
@Expose
private String songAddress;
@SerializedName("lyric")
@Expose
private String lyric;
@SerializedName("avatar")
@Expose
private String avatar;
@SerializedName("adsImage")
@Expose
private Object adsImage;
@SerializedName("adsContent")
@Expose
private Object adsContent;
@SerializedName("listenCount")
@Expose
private Object listenCount;
@SerializedName("favoriteCount")
@Expose
private Object favoriteCount;
@SerializedName("userExtra")
@Expose
private Object userExtra;
@SerializedName("employee")
@Expose
private Object employee;
@SerializedName("album")
@Expose
private Object album;
@SerializedName("favorite")
@Expose
private Object favorite;

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

public String getGenre() {
return genre;
}

public void setGenre(String genre) {
this.genre = genre;
}

public String getVocal() {
return vocal;
}

public void setVocal(String vocal) {
this.vocal = vocal;
}

public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
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

public String getLyric() {
return lyric;
}

public void setLyric(String lyric) {
this.lyric = lyric;
}

public String getAvatar() {
return avatar;
}

public void setAvatar(String avatar) {
this.avatar = avatar;
}

public Object getAdsImage() {
return adsImage;
}

public void setAdsImage(Object adsImage) {
this.adsImage = adsImage;
}

public Object getAdsContent() {
return adsContent;
}

public void setAdsContent(Object adsContent) {
this.adsContent = adsContent;
}

public Object getListenCount() {
return listenCount;
}

public void setListenCount(Object listenCount) {
this.listenCount = listenCount;
}

public Object getFavoriteCount() {
return favoriteCount;
}

public void setFavoriteCount(Object favoriteCount) {
this.favoriteCount = favoriteCount;
}

public Object getUserExtra() {
return userExtra;
}

public void setUserExtra(Object userExtra) {
this.userExtra = userExtra;
}

public Object getEmployee() {
return employee;
}

public void setEmployee(Object employee) {
this.employee = employee;
}

public Object getAlbum() {
return album;
}

public void setAlbum(Object album) {
this.album = album;
}

public Object getFavorite() {
return favorite;
}

public void setFavorite(Object favorite) {
this.favorite = favorite;
}

}
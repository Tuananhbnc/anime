package com.example.anime.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Token implements Serializable {

@SerializedName("id_token")
@Expose
private String idToken;

public String getIdToken() {
return idToken;
}

public void setIdToken(String idToken) {
this.idToken = idToken;
}

}
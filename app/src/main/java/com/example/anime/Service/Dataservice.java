package com.example.anime.Service;

import com.example.anime.Model.Account;
import com.example.anime.Model.Album;
import com.example.anime.Model.Login;
import com.example.anime.Model.Register;
import com.example.anime.Model.Song;
import com.example.anime.Model.Token;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Dataservice {

    @POST("authenticate")
    Call<Token> login(@Body Login login);

    @POST("register")
    Call<ResponseBody> register(@Body Register register);

    @GET("account")
    Call<Account> Getaccount(@Header("Authorization") String authHeader);

    @GET("songs")
    Call<List<Song>> Getsongs(@Header("Authorization") String authHeader);

    @GET("albums")
    Call<List<Album>> Getalbums(@Header("Authorization") String authHeader);


}

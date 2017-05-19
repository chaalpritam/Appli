package com.chaalpritam.apps.appli.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by chaalpritam on 19/5/17.
 */

public interface ApiService {

    @GET("posts")
    Observable<List<Data>> getData();
}

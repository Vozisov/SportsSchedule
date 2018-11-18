package com.vozisov.sportsschedule.config;

import com.vozisov.sportsschedule.model.EventItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("4")
    Call<List<EventItem>> getEventList();
}

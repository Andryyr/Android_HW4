package com.github.Andryyr.task4;

import android.app.Application;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static DownloaderInterface unsplashApi;
    private static Retrofit retrofit;

    private static final String LOG_TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        unsplashApi = retrofit.create(DownloaderInterface.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static DownloaderInterface getApi() {
        return unsplashApi;
    }
}
package com.example.adm22.todo;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by adm22 on 06.07.2017.
 */

public class TodoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}

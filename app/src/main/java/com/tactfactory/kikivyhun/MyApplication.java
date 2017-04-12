package com.tactfactory.kikivyhun;

import android.app.Application;
import android.content.Context;

/**
 * Created by tactfactory on 12/04/17.
 */

public class MyApplication extends Application {

    private static MyApplication instance = null;

    private MyApplication(){
        context = getApplicationContext();
    }

    public static MyApplication getInstance(){
        if(instance == null)
        {
            instance = new MyApplication();
        }
        return instance;
    }

    private Context context;

    public Context getAppContext() {
        return context;
    }
}

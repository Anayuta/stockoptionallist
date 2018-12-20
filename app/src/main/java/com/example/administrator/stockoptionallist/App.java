package com.example.administrator.stockoptionallist;

import android.app.Application;

import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.DefaultAutoAdaptStrategy;

/**
 * Created by Administrator on 2018/12/20.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        AutoSizeConfig.getInstance().setLog(false).setUseDeviceSize(true)
                .setBaseOnWidth(true).setAutoAdaptStrategy(new DefaultAutoAdaptStrategy());
    }
}

package com.bwie.test.liuhaifeng20171118.model.app;

import android.app.Application;

import com.bwie.test.liuhaifeng20171118.gen.DaoMaster;
import com.bwie.test.liuhaifeng20171118.gen.DaoSession;
import com.bwie.test.liuhaifeng20171118.gen.UserDao;

/**
 * 刘海峰.8:50
 */

public class MyApp extends Application {
    public static UserDao userDao;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "lenvess.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
    }
}

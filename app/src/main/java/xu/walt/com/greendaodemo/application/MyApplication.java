package xu.walt.com.greendaodemo.application;

import android.app.Application;
import android.content.Context;

import xu.walt.com.greendaodemo.utils.DateBaseManager;

/**
 * Created by walt on 2019/4/15.
 */

public class MyApplication extends Application {
    private static Context mContext;
    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        DateBaseManager.getInstance(getApplicationContext());
    }

    public static Context getmContext() {
        return mContext;
    }

    public static MyApplication getmInstance() {
        if (mInstance == null) {
            mInstance = new MyApplication();
        }
        return mInstance;
    }
}

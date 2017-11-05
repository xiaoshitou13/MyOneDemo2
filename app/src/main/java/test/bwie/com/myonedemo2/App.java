package test.bwie.com.myonedemo2;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 白玉春 on 2017/11/4.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(getApplicationContext());
    }
}

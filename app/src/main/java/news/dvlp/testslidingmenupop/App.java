package news.dvlp.testslidingmenupop;

import android.app.Application;

import news.dvlp.testslidingmenupop.zviews.Utils;

/**
 * Created by liubaigang on 2018/8/13.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(getApplicationContext());
    }
}

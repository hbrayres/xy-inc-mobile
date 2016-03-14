package br.com.zup.filmesimdb.application;

import android.app.Application;
import android.content.Context;

import com.orm.SugarContext;

/**
 * Created by heber.junior on 13/03/2016.
 */
public class FilmesImdbApplication extends Application {

    private static Context sContext;
    private static FilmesImdbApplication sInstante;

    @Override
    public void onCreate() {
        super.onCreate();

        synchronized (FilmesImdbApplication.class) {
            if (sContext == null) {
                sContext = getApplicationContext();
            }
            if (sInstante == null) {
                sInstante = this;
            }

            SugarContext.init(this);
        }
    }
}

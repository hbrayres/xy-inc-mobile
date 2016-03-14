package br.com.zup.filmesimdb.activities;

import android.content.Context;
import android.view.View;

/**
 * Created by heber.junior on 12/03/2016.
 */
public interface IViewDetailActivity {

    Context getBaseContext();

    View findViewById(final int id);

}


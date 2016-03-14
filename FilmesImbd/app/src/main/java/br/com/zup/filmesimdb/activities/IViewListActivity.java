package br.com.zup.filmesimdb.activities;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import br.com.zup.filmesimdb.model.Filme;

/**
 * Created by heber.junior on 11/03/2016.
 */
public interface IViewListActivity {

    Context getBaseContext();

    View findViewById(final int id);

    void onResultList(final List<Filme> filmes);

    void setSupportActionBar(Toolbar toolbar);

    void startSearch();

    void onErrorSearch(final String errorMsg);

    void onSuccess(final Filme filme);

}

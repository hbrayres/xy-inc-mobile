package br.com.zup.filmesimdb.holder;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import br.com.zup.filmesimbd.R;
import br.com.zup.filmesimdb.activities.IViewListActivity;

/**
 * Created by heber.junior on 11/03/2016.
 */
public class HolderActMain {

    private IViewListActivity mView;
    private View noResulFound;
    private ListView lvFilmes;
    private FloatingActionButton mFabAddFilme;
    private View viewLoading;
    private View includeLoading;

    public HolderActMain(final IViewListActivity app) {
        mView = app;
        initializeFields();
    }

    private void initializeFields() {
        noResulFound = getView(R.id.no_result_found);
        lvFilmes = (ListView) getView(R.id.lv_filmes);
        mFabAddFilme = (FloatingActionButton) getView(R.id.fab);
        includeLoading = getView(R.id.include_loading);
        viewLoading = getView(R.id.iv_loading);
        Toolbar toolbar = (Toolbar) getView(R.id.toolbar);
        mView.setSupportActionBar(toolbar);
    }

    public void setHasItens(final boolean hasItens) {
        if (hasItens) {
            noResulFound.setVisibility(View.GONE);
            lvFilmes.setVisibility(View.VISIBLE);
        } else {
            noResulFound.setVisibility(View.VISIBLE);
            lvFilmes.setVisibility(View.GONE);
        }
    }

    public void showLoading(final Boolean show) {
        if (includeLoading != null && viewLoading != null) {
            includeLoading.setVisibility( show ? View.VISIBLE : View.GONE);
            //viewLoading.setVisibility( show ? View.VISIBLE : View.GONE);
            if (show) {
                animatingRotationView(viewLoading);
            }
        }
    }

    private void animatingRotationView(final View view) {
        final Animation rotation = AnimationUtils.loadAnimation(mView.getBaseContext(), R.anim.inifiti_rotation);
        if (rotation != null) {
            view.setAnimation(rotation);
            rotation.start();
        }
    }

    public View getView(int id) {
        return mView.findViewById(id);
    }

    public View getNoResulFound() {
        return noResulFound;
    }

    public void setNoResulFound(View noResulFound) {
        this.noResulFound = noResulFound;
    }

    public ListView getLvFilmes() {
        return lvFilmes;
    }

    public void setLvFilmes(ListView lvFilmes) {
        this.lvFilmes = lvFilmes;
    }

    public FloatingActionButton getFabAddFilme() {
        return mFabAddFilme;
    }

    public void setFabAddFilme(FloatingActionButton mFabAddFilme) {
        this.mFabAddFilme = mFabAddFilme;
    }
}

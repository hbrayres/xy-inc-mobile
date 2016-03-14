package br.com.zup.filmesimdb.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.com.zup.filmesimbd.R;
import br.com.zup.filmesimdb.holder.HolderActFilmeDetail;
import br.com.zup.filmesimdb.model.Filme;
import br.com.zup.filmesimdb.util.Constantes;

public class ActFilmeDetail extends AppCompatActivity implements IViewDetailActivity {

    private Filme mSelected;
    private HolderActFilmeDetail mHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_filme_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        checkIntent();
        initialize();
    }

    private void checkIntent() {
        mSelected = new Filme();
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(Constantes.ITEM_DETAIL)) {
            mSelected = (Filme) getIntent().getExtras().getSerializable(Constantes.ITEM_DETAIL);
        }
    }

    private void initialize() {
        mHolder = new HolderActFilmeDetail(this);
        if (mSelected != null) {
            mHolder.setupDetail(mSelected);
        }
    }

}

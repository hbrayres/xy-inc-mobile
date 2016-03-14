package br.com.zup.filmesimdb.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.zup.filmesimbd.R;
import br.com.zup.filmesimdb.adapter.AdpActMain;
import br.com.zup.filmesimdb.controller.ActMainController;
import br.com.zup.filmesimdb.controller.IActMainController;
import br.com.zup.filmesimdb.dialogs.NewMovieDialog;
import br.com.zup.filmesimdb.holder.HolderActMain;
import br.com.zup.filmesimdb.model.Filme;
import br.com.zup.filmesimdb.util.Constantes;

public class ActMain extends AppCompatActivity implements IViewListActivity {

    private IActMainController mController;
    private HolderActMain mHolder;
    private AdpActMain mAdapter;
    private NewMovieDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        initialize();
        setActionsListener();
    }

    @Override
    protected void onResume() {
        listarFilmes();
        super.onResume();
    }

    private void initialize() {
        mController = new ActMainController(this);
        mHolder = new HolderActMain(this);
    }

    private void setActionsListener() {
        if (mHolder != null) {
            mHolder.getFabAddFilme().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialogNewMovie();
                }
            });

            mHolder.getLvFilmes().setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(final AdapterView<?> adapterView, final View view, int position, final long id) {
                    if (mAdapter != null) {
                        startActFilmeDetail(mAdapter.getItem(position));
                    }
                }
            });
        }
    }

    private void startActFilmeDetail(final Filme filme) {
        final Intent itDetail = new Intent(this, ActFilmeDetail.class);
        itDetail.putExtra(Constantes.ITEM_DETAIL, filme);
        this.startActivity(itDetail);
    }

    private void showDialogNewMovie() {
        final NewMovieDialog dialog = new NewMovieDialog(this, mController);
        dialog.showDialog();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_act_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void listarFilmes() {
        mController.listarFilmes();

    }
    @Override
    public void onResultList(final List<Filme> filmes) {
        Snackbar.make(mHolder.getFabAddFilme(), String.format("Resultado encontrado: %d filme(s)", filmes.size()),
                Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();

        mHolder.setHasItens(!filmes.isEmpty());

        if (mAdapter == null) {
            mAdapter = new AdpActMain(getBaseContext());
        }
        mAdapter.setItens(filmes);
        mHolder.getLvFilmes().setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void startSearch() {
        mHolder.showLoading(true);
    }

    @Override
    public void onErrorSearch(final String errorMsg) {
        mHolder.showLoading(false);
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(final Filme filme) {
        mHolder.showLoading(false);
        startActFilmeDetail(filme);
    }
}

package br.com.zup.filmesimdb.holder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.zup.filmesimbd.R;
import br.com.zup.filmesimdb.activities.IViewDetailActivity;
import br.com.zup.filmesimdb.model.Filme;

/**
 * Created by heber.junior on 12/03/2016.
 */
public class HolderActFilmeDetail {

    private IViewDetailActivity mView;
    private TextView tvTitle;
    private TextView tvSubtitle;
    private TextView tvRated;
    private TextView tvDirector;
    private TextView tvActors;
    private TextView tvPlot;
    private ImageView ivPoster;

    public HolderActFilmeDetail(final IViewDetailActivity view) {
        mView = view;
        initializeFields();
    }

    private void initializeFields() {
        tvTitle = (TextView) getView(R.id.tv_title_detail);
        tvSubtitle = (TextView) getView(R.id.tv_subtitle);
        tvRated = (TextView) getView(R.id.tv_rated_detail);
        tvDirector = (TextView) getView(R.id.tv_director_detail);
        tvActors = (TextView) getView(R.id.tv_actors_detail);
        tvPlot = (TextView) getView(R.id.tv_plot);
        ivPoster = (ImageView) getView(R.id.iv_poster);
    }

    public void setupDetail(final Filme filme) {
        setTextViewAndShow(tvTitle, filme.getTitle());

        final String subtitle = String.format("%s | %s | %s ", filme.getYear(), filme.getGenre(), filme.getRuntime());
        setTextViewAndShow(tvSubtitle, subtitle);

        setTextViewAndShow(tvRated, String.format("%s/10", filme.getImdbRating()));
        setTextViewAndShow(tvDirector, String.format("Diretores: %s", filme.getDirector()));
        setTextViewAndShow(tvActors, String.format("Atores: %s", filme.getActors()));
        setTextViewAndShow(tvPlot, filme.getPlot());
        loadImage(filme.getPoster());
    }

    /**
     * Set value to TextView and show if has any information or GONE TextView otherwise
     * @param tv
     * @param value
     */
    private void setTextViewAndShow(final TextView tv, final Object value) {
        if (tv != null) {
            tv.setVisibility(View.GONE);
            if (value != null && !value.toString().isEmpty()) {
                tv.setText(value.toString());
                tv.setVisibility(View.VISIBLE);
            }
        }
    }

    private void loadImage(final String url) {
        Picasso.with(mView.getBaseContext()).load(url)
                .resizeDimen(R.dimen.width_poster_detail, R.dimen.height_poster_detail) // dimensao do ImageView na tela
                .centerInside() // centraliza no ImageView
                //.error() //set imagem caso nao encontre no URL
                .into(ivPoster);
    }

    private View getView(int id) {
        return mView.findViewById(id);
    }

}

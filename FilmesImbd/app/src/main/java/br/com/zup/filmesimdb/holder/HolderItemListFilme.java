package br.com.zup.filmesimdb.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.zup.filmesimbd.R;
import br.com.zup.filmesimdb.model.Filme;

/**
 * Created by heber.junior on 11/03/2016.
 */
public class HolderItemListFilme {

    private View mView;
    private TextView tvTitle;
    private TextView tvSubTitle;
    private ImageView ivPoster;

    public HolderItemListFilme(final View app) {
        mView = app;
        initializeFields();
    }

    public void initializeFields() {
        tvTitle = (TextView) getView(R.id.tv_item_titulo);
        tvSubTitle = (TextView) getView(R.id.tv_item_subtitulo);
        ivPoster = (ImageView) getView(R.id.iv_poster_list);
    }

    public void setItem(final Filme filme) {
        tvTitle.setText(String.format("%s (%s)", filme.getTitle(), filme.getYear()));
        tvSubTitle.setText(String.format("%s - %s", filme.getGenre(), filme.getRuntime()));
        loadImage(filme.getPoster());
    }

    private void loadImage(final String url) {
        try {
            Picasso.with(mView.getContext()).load(url)
                    .resizeDimen(R.dimen.width_poster_list, R.dimen.height_poster_list)
                    .centerInside()
                    .into(ivPoster);
        } catch (Exception e) {
        }
    }
    public View getView(final int id) {
        return mView.findViewById(id);
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvSubTitle() {
        return tvSubTitle;
    }

    public ImageView getIvPoster() {
        return ivPoster;
    }
}

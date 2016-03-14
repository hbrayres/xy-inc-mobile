package br.com.zup.filmesimdb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.zup.filmesimbd.R;
import br.com.zup.filmesimdb.holder.HolderItemListFilme;
import br.com.zup.filmesimdb.model.Filme;

/**
 * Created by heber.junior on 11/03/2016.
 */
public class AdpActMain extends BaseAdapter {

    private List<Filme> itens;
    private Context mContext;

    public AdpActMain(final Context c) {
        mContext = c;
    }

    public AdpActMain(final Context c, final List<Filme> fonte) {
        mContext = c;
        itens = fonte;
    }

    @Override
    public int getCount() {
        if (itens != null) {
            return itens.size();
        }
        return 0;
    }

    @Override
    public Filme getItem(int position) {
        if (!hasItens() || position >= itens.size() || position < 0) {
            return null;
        }
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        HolderItemListFilme holderItem = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_filme, null);
            holderItem = new HolderItemListFilme(convertView);
            convertView.setTag(holderItem);
        } else {
            holderItem = (HolderItemListFilme) convertView.getTag();
        }

        final Filme filme = getItem(position);
        if (filme != null) {
            holderItem.setItem(filme);
        }

        return convertView;
    }

    public boolean hasItens() {
        return itens != null && !itens.isEmpty();
    }

    public List<Filme> getItens() {
        return itens;
    }

    public void setItens(List<Filme> itens) {
        this.itens = itens;
    }
}

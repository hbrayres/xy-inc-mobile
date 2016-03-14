package br.com.zup.filmesimdb.controller;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import br.com.zup.filmesimdb.model.Filme;

/**
 * Created by heber.junior on 11/03/2016.
 */
public interface IActMainController {

    void searchMovie(final String titleSearch);

    void onSuccessResponse(final Filme filme);

    void listarFilmes();
}

package br.com.zup.filmesimdb.controller;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.net.UnknownHostException;
import java.util.List;

import br.com.zup.filmesimdb.activities.IViewListActivity;
import br.com.zup.filmesimdb.model.Filme;
import br.com.zup.filmesimdb.request.GsonRequest;

/**
 * Created by heber.junior on 11/03/2016.
 */
public class ActMainController implements IActMainController {

    private IViewListActivity mView;

    private RequestQueue rq;

    public ActMainController(final IViewListActivity app) {
        mView = app;
    }

    @Override
    public void searchMovie(final String titleSearch) {
        mView.startSearch();
        final String url = String.format("http://www.omdbapi.com/?y=&plot=full&r=json&t=%s", titleSearch.replace(" ", "+"));

        rq = Volley.newRequestQueue(mView.getBaseContext());
        final GsonRequest<Filme> gsonRequest = new GsonRequest<Filme>(
                Request.Method.GET, url, Filme.class, successListener(), errorListener());
        rq.add(gsonRequest);
    }

    private Response.Listener successListener() {
        return new Response.Listener<Filme>() {
            @Override
            public void onResponse(final Filme response) {
                if (!response.isResponse()) {
                    onErrorSearch("Filme não encontrado");
                } else {
                    onSuccessResponse(response);
                }
            }
        };
    }

    private Response.ErrorListener errorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(final VolleyError error) {
                if (error.getCause() instanceof UnknownHostException) {
                    onErrorSearch("Falha na conexão com o serviço. Verifique a conexao com a internet");
                } else {
                    onErrorSearch(error.getMessage());
                }
            }
        };
    }

    public void onErrorSearch(final String error) {
        mView.onErrorSearch(error);
    }

    @Override
    public void onSuccessResponse(final Filme filme) {
        final List<Filme> result = Filme.find(Filme.class, "title = ? and year = ?", filme.getTitle(), filme.getYear().toString());
        if (result != null && !result.isEmpty()) {
            filme.setId(result.get(0).getId());
        } else {
            filme.save();
        }
        mView.onSuccess(filme);
    }

    @Override
    public void listarFilmes() {
        final List<Filme> filmes = Filme.listAll(Filme.class, "title asc");
        mView.onResultList(filmes);
    }
}

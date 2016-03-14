package br.com.zup.filmesimdb.request;

import android.media.UnsupportedSchemeException;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;

/**
 * Created by heber.junior on 12/03/2016.
 */
public class GsonRequest<T> extends Request<T> {

    private Response.Listener<T> mListener;
    private Class<T> mClazz;
    private Gson mGson;

    public GsonRequest(final int method, final String url, final Class<T> clazz,
                       final Response.Listener<T> listener, final Response.ErrorListener listenerError) {
        super(method, url, listenerError);
        mClazz = clazz;
        mListener = listener;
        mGson = new Gson();
    }

    public GsonRequest(final int method, final String url, final Class<T> clazz,
                       final Response.Listener<T> listener, final Response.ErrorListener listenerError,
                       final Gson gson) {
        super(method, url, listenerError);
        mClazz = clazz;
        mListener = listener;
        mGson = gson;
    }

    @Override
    protected Response<T> parseNetworkResponse(final NetworkResponse response) {
        try {
            final String json = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(mGson.fromJson(json, mClazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(final T response) {
        mListener.onResponse(response);
    }
}

package br.com.zup.filmesimdb.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.wifi.WifiManager;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import br.com.zup.filmesimbd.R;
import br.com.zup.filmesimdb.activities.IViewListActivity;
import br.com.zup.filmesimdb.controller.IActMainController;
import br.com.zup.filmesimdb.widget.ZUPEditText;

/**
 * Created by heber.junior on 12/03/2016.
 */
public class NewMovieDialog {

    private IActMainController mController;
    private IViewListActivity mView;

    private Context mContext;
    private AlertDialog mDialog;
    private ZUPEditText etTitulo;
    private Button btnCancel;
    private Button btnSearch;

    public NewMovieDialog(final Context context, final IActMainController controller) {
        mContext = context;
        mController = controller;
    }

    private void initialize(final View view) {
        etTitulo = (ZUPEditText) view.findViewById(R.id.et_title_dialog);
        btnCancel = (Button) view.findViewById(R.id.btn_cancel);
        btnSearch = (Button) view.findViewById(R.id.btn_confirm);
    }
    public void showDialog() {
        mDialog = builderDialog().create();
        mDialog.show();
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    private AlertDialog.Builder builderDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.dilaog_new_movie, null);

        initialize(view);
        getEtTitulo().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    mDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        getBtnCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });

        getBtnSearch().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(getEtTitulo().getText().toString())) {
                    Snackbar.make(view, "Título é obrigatório", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    mDialog.dismiss();
                    mController.searchMovie(getEtTitulo().getText().toString());

                }
            }
        });

        builder.setView(view);
        return builder;
    }

    public TextView getEtTitulo() {
        return etTitulo;
    }

    public Button getBtnCancel() {
        return btnCancel;
    }

    public Button getBtnSearch() {
        return btnSearch;
    }
}

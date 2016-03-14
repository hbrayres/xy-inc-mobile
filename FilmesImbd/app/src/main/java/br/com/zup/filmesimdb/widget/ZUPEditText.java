package br.com.zup.filmesimdb.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import br.com.zup.filmesimbd.R;
import br.com.zup.filmesimdb.util.EFontType;
import br.com.zup.filmesimdb.util.FontLoader;

/**
 * Classe utilitaria para evitar problemas com crash em alguns smartphones samsgung.
 *
 * Created by heber.junior on 12/03/2016.
 */
public class ZUPEditText extends EditText implements View.OnTouchListener {
    public ZUPEditText(Context context) {
        super(context);
    }

    public ZUPEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZUPEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void customize(Context context, final AttributeSet attrs) {
        final TypedArray editTextAttr = context.obtainStyledAttributes(attrs, R.styleable.ZUPWidget);
        final String attribute = editTextAttr.getString(R.styleable.ZUPWidget_zupFontType);

        setTypeface(FontLoader.getTypeFace(EFontType.getFontByName(attribute), context));
        editTextAttr.recycle();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}

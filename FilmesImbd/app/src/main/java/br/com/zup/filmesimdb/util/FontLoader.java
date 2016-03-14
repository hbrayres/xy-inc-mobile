package br.com.zup.filmesimdb.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by heber.junior on 12/03/2016.
 */
public class FontLoader {


    private static HashMap<EFontType, Typeface> mFontMaps = new HashMap<EFontType, Typeface>();

    private FontLoader() {
	/* so that PMD stops complaining */
    }

    public static final Typeface getTypeFace(EFontType type, final Context context) {

        Typeface font = null;

        if (type == null) {
            type = EFontType.ROBOTO_LIGHT;
        } else {
            font = mFontMaps.get(type);
        }

        if (font == null) {
            font = Typeface.createFromAsset(context.getAssets(), type.getFontPath());
            mFontMaps.put(type, font);
        }

        return font;
    }

    public static final void setActivityTitleTypeface(final Activity activity, final EFontType type) {
        final int actionBarTitle = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        final TextView actBarTitleView = (TextView) activity.getWindow().findViewById(actionBarTitle);
        if (actBarTitleView != null) {
            actBarTitleView.setTypeface(getTypeFace(type, activity));
        }
    }

}

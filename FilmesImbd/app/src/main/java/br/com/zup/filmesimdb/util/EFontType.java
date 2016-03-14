package br.com.zup.filmesimdb.util;

/**
 * Created by heber.junior on 12/03/2016.
 */
public enum EFontType {
    ROBOTO_LIGHT("roboto_light", "fonts/roboto_light.ttf"), ROBOTO_REGULAR("roboto_regular",
            "fonts/roboto_regular.ttf"), ROBOTO_BOLD("roboto_bold", "fonts/roboto_bold.ttf");

    private String mFontName;
    private String mFontPath;

    private EFontType(final String fontName, final String fontPath) {
        mFontName = fontName;
        mFontPath = fontPath;
    }

    public String getFontName() {
        return mFontName;
    }

    public String getFontPath() {
        return mFontPath;
    }

    public static EFontType getFontByName(final String fontName) {
        for (final EFontType fontType : EFontType.values()) {
            if (fontType.getFontName().equalsIgnoreCase(fontName)) {
                return fontType;
            }
        }
        return null;
    }
}

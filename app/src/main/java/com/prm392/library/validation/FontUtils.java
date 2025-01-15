package com.prm392.library.validation;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FontUtils {
    public static void applyFont(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("fonts", Context.MODE_PRIVATE);
        int selectedFontPosition = sharedPreferences.getInt("selectedFontPosition", 0);
        Typeface typeface = getTypefaceForPosition(context, selectedFontPosition);

        ViewGroup viewGroup = (ViewGroup) ((Activity) context).findViewById(android.R.id.content).getRootView();
        setFontForViewGroup(viewGroup, typeface);
    }

    private static Typeface getTypefaceForPosition(Context context, int position) {
        switch (position) {
            case 0:
                return Utils.getDefaultFont(context);

            case 1:
                return Utils.getBlack(context);
            case 2:
                return Utils.getBold(context);
            case 3:
                return Utils.getExtraLight(context);
            case 4:
                return Utils.getRegular(context);
            case 5:
                return Utils.getRoboto(context);
            default:
                return Utils.getDefaultFont(context);
        }
    }

    private static void setFontForViewGroup(ViewGroup viewGroup, Typeface typeface) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                setFontForViewGroup((ViewGroup) child, typeface);
            } else if (child instanceof TextView) {
                ((TextView) child).setTypeface(typeface);
            }
        }
    }
}

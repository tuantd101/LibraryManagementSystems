package com.prm392.library.validation;

import android.content.Context;
import android.graphics.Typeface;

public class Utils {
    public static Long EMPLOYEE_A = 1L;
    public static Long EMPLOYEE_B = 2L;
    public static Long MANAGER = 3L;
    private static Typeface Black;
    private static Typeface Bold;
    private static Typeface ExtraLight;
    private static Typeface Regular;
    private static Typeface Roboto;
    private static Typeface RobotoFlex;

    public static Typeface getBlack(Context context) {
        if(Black ==null){
            Black = Typeface.createFromAsset(context.getAssets(),"fonts/SourceSansPro-Black.otf");
        }
        return Black;
    }

    public static Typeface getBold(Context context) {
       if(Bold ==null){
           Bold = Typeface.createFromAsset(context.getAssets(),"fonts/SourceSansPro-Bold.otf");
       }
        return Bold;
    }

    public static Typeface getExtraLight(Context context) {
        if(ExtraLight ==null){
            ExtraLight = Typeface.createFromAsset(context.getAssets(),"fonts/SourceSansPro-ExtraLight.otf");
        }
        return ExtraLight;
    }

    public static Typeface getRegular(Context context) {
        if(Regular ==null){
            Regular = Typeface.createFromAsset(context.getAssets(),"fonts/SourceSansPro-Regular.otf");
        }
        return Regular;
    }

    public static Typeface getRoboto(Context context) {
        if(Roboto ==null){
            Roboto = Typeface.createFromAsset(context.getAssets(),"fonts/Roboto-Italic.ttf");
        }
        return Roboto;
    }

    public static Typeface getDefaultFont(Context context) {
        if(RobotoFlex ==null){
            RobotoFlex = Typeface.createFromAsset(context.getAssets(),"fonts/RobotoFlex-Regular.ttf");
        }
        return RobotoFlex;
    }
}

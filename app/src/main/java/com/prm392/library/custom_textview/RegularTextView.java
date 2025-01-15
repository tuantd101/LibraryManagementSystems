package com.prm392.library.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.prm392.library.validation.Utils;

public class RegularTextView extends AppCompatTextView {
    public RegularTextView(@NonNull Context context) {
        super(context);
        setFontTextView();
    }

    public RegularTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontTextView();
    }

    public RegularTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontTextView();
    }
    private void setFontTextView(){
        Typeface typeface = Utils.getRegular(getContext());
        setTypeface(typeface);
    }
}

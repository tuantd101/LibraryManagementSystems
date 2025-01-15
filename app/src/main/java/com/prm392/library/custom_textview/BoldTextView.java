package com.prm392.library.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.prm392.library.validation.Utils;

public class BoldTextView extends AppCompatTextView {
    public BoldTextView(@NonNull Context context) {
        super(context);
        setFontTextView();
    }

    public BoldTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontTextView();
    }

    public BoldTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontTextView();
    }
    private void setFontTextView(){
        Typeface typeface = Utils.getBold(getContext());
        setTypeface(typeface);
    }
}

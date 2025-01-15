package com.prm392.library.custom_textview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.prm392.library.validation.Utils;

public class RobotoTextView extends AppCompatTextView {
    public RobotoTextView(@NonNull Context context) {
        super(context);
        setFontTextView();
    }

    public RobotoTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontTextView();
    }

    public RobotoTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontTextView();
    } private void setFontTextView(){
        Typeface typeface = Utils.getRoboto(getContext());
        setTypeface(typeface);
    }
}

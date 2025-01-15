package com.prm392.library.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.prm392.library.R;
import com.prm392.library.validation.FontUtils;

public class Font_And_Mode extends AppCompatActivity {
    Spinner spinner;

    private static final String SHARE_FONTS = "fonts";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_text);
        spinner = findViewById(R.id.list_fonts);
        FontUtils.applyFont(this);
        Switch switchDarkMode = findViewById(R.id.switchDarkMode);

        switchDarkMode.setChecked((getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK)
                == android.content.res.Configuration.UI_MODE_NIGHT_YES);

        switchDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Turn on/off dark mode based on the switch state
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                recreate();
            }
        });

    sharedPreferences=getSharedPreferences(SHARE_FONTS,MODE_PRIVATE);
    editor = sharedPreferences.edit();
        changeFontFamily();
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("selectedFontPosition", position);
            editor.apply();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


    });

    }
    @SuppressLint("ResourceType")
    private void changeFontFamily(){
        final String[] fonts = {"Default Font","Black", "Bold", "ExtraLight", "Regular", "Roboto"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, fonts);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }
}
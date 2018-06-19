package com.xunlei.downloadprovider.vod.subtitle;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.xunlei.downloadprovider.R;

public class FontSizeSelectView extends RadioGroup {
    public FontSizeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(null);
        setGravity(1);
        View radioButton = new RadioButton(context);
        radioButton.setText(R.string.font_size_small);
        radioButton.setButtonDrawable(null);
        radioButton.setTextSize(14.0f);
        if (VERSION.SDK_INT >= 23) {
            radioButton.setTextColor(context.getResources().getColorStateList(R.color.subtitle_font_size_color_selector, null));
        } else {
            radioButton.setTextColor(context.getResources().getColorStateList(R.color.subtitle_font_size_color_selector));
        }
        addView(radioButton);
        radioButton = new RadioButton(context);
        radioButton.setText(R.string.font_size_standard);
        radioButton.setButtonDrawable(null);
        radioButton.setTextSize(14.0f);
        if (VERSION.SDK_INT >= 23) {
            radioButton.setTextColor(context.getResources().getColorStateList(R.color.subtitle_font_size_color_selector, null));
        } else {
            radioButton.setTextColor(context.getResources().getColorStateList(R.color.subtitle_font_size_color_selector));
        }
        addView(radioButton);
        View radioButton2 = new RadioButton(context);
        radioButton2.setText(R.string.font_size_standard);
        radioButton2.setButtonDrawable(null);
        radioButton2.setTextSize(14.0f);
        if (VERSION.SDK_INT >= 23) {
            radioButton2.setTextColor(context.getResources().getColorStateList(R.color.subtitle_font_size_color_selector, null));
        } else {
            radioButton2.setTextColor(context.getResources().getColorStateList(R.color.subtitle_font_size_color_selector));
        }
        addView(radioButton2);
        radioButton.setChecked(true);
    }
}

package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.xunlei.common.commonview.dialog.XLCheckBoxDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.util.a;

/* compiled from: DownloadRemoveConfirmDialog */
public final class z extends XLCheckBoxDialog {
    public z(Context context, int i, int i2, long j) {
        super(context, "取消", "确定");
        setContent("确定删除下载任务?");
        if (i > 0 && i2 > 0) {
            Object format = String.format(context.getString(R.string.alert_delete_content), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            int[] iArr = new int[]{format.indexOf(String.valueOf(i)), format.lastIndexOf(String.valueOf(i2))};
            CharSequence spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), 0, iArr[0], 34);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#1294F6")), iArr[0], iArr[0] + String.valueOf(i).length(), 34);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), iArr[0] + String.valueOf(i).length(), iArr[1], 34);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#1294F6")), iArr[1], iArr[1] + String.valueOf(i2).length(), 34);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), iArr[1] + String.valueOf(i2).length(), format.length(), 34);
            getmContentText().setText(spannableStringBuilder);
        } else if (i > 0 && i2 <= 0) {
            i2 = String.format(context.getString(R.string.alert_delete_content_zero_unfinish), new Object[]{Integer.valueOf(i)});
            r3 = new int[]{i2.indexOf(String.valueOf(i))};
            r4 = new SpannableStringBuilder(i2);
            r4.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), 0, r3[0], 34);
            r4.setSpan(new ForegroundColorSpan(Color.parseColor("#1294F6")), r3[0], r3[0] + String.valueOf(i).length(), 34);
            r4.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), r3[0] + String.valueOf(i).length(), i2.length(), 34);
            getmContentText().setText(r4);
        } else if (i <= 0 && i2 > 0) {
            i = String.format(context.getString(R.string.alert_delete_content_zero_finish), new Object[]{Integer.valueOf(i2)});
            r3 = new int[]{i.indexOf(String.valueOf(i2))};
            r4 = new SpannableStringBuilder(i);
            r4.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), 0, r3[0], 34);
            r4.setSpan(new ForegroundColorSpan(Color.parseColor("#1294F6")), r3[0], r3[0] + String.valueOf(i2).length(), 34);
            r4.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), r3[0] + String.valueOf(i2).length(), i.length(), 34);
            getmContentText().setText(r4);
        }
        i = a.c(j);
        context = String.format(context.getString(R.string.alert_delete_size), new Object[]{i});
        i2 = new int[]{context.indexOf(i)};
        i = new SpannableStringBuilder(context);
        i.setSpan(new ForegroundColorSpan(Color.parseColor("#333333")), 0, i2[0], 34);
        i.setSpan(new ForegroundColorSpan(Color.parseColor("#1294F6")), i2[0], context.length(), 34);
        getmSizeText().setVisibility(0);
        getmSizeText().setText(i);
        setChecked(true);
        setCheckStr("同时删除本地文件");
    }
}

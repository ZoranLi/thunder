package com.xunlei.downloadprovider.download.player.views.member.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import com.xunlei.downloadprovider.R;
import java.text.DecimalFormat;

public class MemberSpeedTextView extends AppCompatTextView {
    public ForegroundColorSpan a;
    public ForegroundColorSpan b;

    public MemberSpeedTextView(Context context) {
        this(context, null, 0);
    }

    public MemberSpeedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MemberSpeedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setTextSize(12.0f);
        setGravity(17);
        setTextColor(Color.parseColor("#FFFFFF"));
        this.a = new ForegroundColorSpan(getResources().getColor(R.color.blue_dark));
        this.b = new ForegroundColorSpan(Color.parseColor("#ff733b"));
    }

    public static String a(Context context, long j) {
        j = j > 0 ? (double) (j / 1024) : 0;
        if (j > 4661225614328463360L) {
            j = 4661225614328463360L;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        if (j >= 4652218415073722368L) {
            j /= 4652218415073722368L;
            return String.format(context.getResources().getString(R.string.vod_speed_format_mb), new Object[]{decimalFormat.format(j)});
        }
        return String.format(context.getResources().getString(R.string.vod_speed_format_kb), new Object[]{decimalFormat.format(j)});
    }
}

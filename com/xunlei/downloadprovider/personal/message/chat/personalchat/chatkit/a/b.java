package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.a;

import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import java.text.NumberFormat;

/* compiled from: UnreadCountHelper */
public final class b {
    public static void a(TextView textView, int i) {
        if (i <= 0) {
            i = "";
        } else if (i < 1000) {
            i = String.valueOf(i);
        } else if (i < 10000) {
            NumberFormat instance = NumberFormat.getInstance();
            instance.setMaximumFractionDigits(1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(instance.format(((double) i) / 1000.0d));
            stringBuilder.append("k");
            i = stringBuilder.toString();
        } else {
            i = "1w+";
        }
        if (i.length() == 1) {
            textView.setBackgroundResource(R.drawable.message_center_unread_count_bg);
        } else {
            textView.setBackgroundResource(R.drawable.message_center_unread_count_long_bg);
        }
        textView.setText(i);
        textView.setVisibility(i.isEmpty() != 0 ? 4 : 0);
    }
}

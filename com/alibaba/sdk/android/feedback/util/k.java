package com.alibaba.sdk.android.feedback.util;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;

public class k {
    private static int a;
    private static int b;
    private static Handler c = new Handler(Looper.getMainLooper());

    public static int a() {
        return a;
    }

    public static void a(int i) {
        a = i;
    }

    public static void a(Context context) {
        TextView textView = (TextView) ((Activity) context).findViewById(R.id.title_button);
        if (textView != null) {
            textView.setVisibility(4);
        }
        f(context);
    }

    public static void a(Context context, int i) {
        b = i;
        ((Activity) context).findViewById(R.id.title).setBackgroundColor(i);
    }

    public static void a(Context context, String str) {
        TextView textView = (TextView) ((Activity) context).findViewById(R.id.title_button);
        if (textView != null) {
            textView.setTextColor(a());
            textView.setText(str);
            textView.setVisibility(0);
        }
        FeedbackAPI.getFeedbackUnreadCount(new l(context));
    }

    public static void a(boolean z, Context context) {
        c.post(new m(z, context));
    }

    public static void b(int i) {
        b = i;
    }

    public static void b(Context context) {
        ((Activity) context).findViewById(R.id.title).setBackgroundColor(b);
    }

    public static void b(Context context, String str) {
        TextView textView = (TextView) ((Activity) context).findViewById(R.id.title_text);
        if (textView != null) {
            textView.setTextColor(a());
            textView.setText(str);
            textView.setVisibility(0);
        }
    }

    private static void e(Context context) {
        View findViewById = ((Activity) context).findViewById(R.id.red_point);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
    }

    private static void f(Context context) {
        View findViewById = ((Activity) context).findViewById(R.id.red_point);
        if (findViewById != null) {
            findViewById.setVisibility(4);
        }
    }
}

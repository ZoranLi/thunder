package com.alibaba.baichuan.android.trade.d;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.baichuan.android.trade.ui.activity.AlibcWebViewActivity;
import java.io.Serializable;

public class a {
    public static final a a = new a();
    private static final String b = "a";

    private a() {
    }

    public static void a(Activity activity, String str, Serializable serializable, com.alibaba.baichuan.android.trade.b.a aVar) {
        Intent intent = new Intent(activity, AlibcWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("ui_contextParams", serializable);
        com.alibaba.baichuan.android.trade.callback.a.a = aVar;
        activity.startActivityForResult(intent, AlibcWebViewActivity.e);
    }
}
